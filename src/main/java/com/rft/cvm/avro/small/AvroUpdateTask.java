package com.rft.cvm.avro.small;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import org.apache.avro.file.DataFileStream;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.rft.cvm.avro.Vehicle;
import com.rft.cvm.util.AWSCredentialsUtil;
import com.rft.cvm.util.Const;

public class AvroUpdateTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 10;
	private List<JSONObject> vehicles;

	public AvroUpdateTask(List<JSONObject> vehicles) {
		this.vehicles = vehicles;
	}

	protected Integer compute() {
		int sum = 0;
		boolean canCompute = vehicles.size() <= THRESHOLD;
		DatumWriter<Vehicle> userDatumWriter = new SpecificDatumWriter<Vehicle>(Vehicle.class);
		DataFileWriter<Vehicle> dataFileWriter = new DataFileWriter<Vehicle>(userDatumWriter);

		DatumReader<Vehicle> userDatumReader = new SpecificDatumReader<Vehicle>(Vehicle.class);
		if (canCompute) {
			// remote
			AWSCredentials credentials = AWSCredentialsUtil.getAWSCredentials();
			AmazonS3 s3client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2)
					.build();
			for (int i = 0; i < vehicles.size(); i++) {

				long id = vehicles.get(i).getLongValue("id");

				// local
				// String sourceFile = "result/" + id + ".avro";
				// remote
				String sourceFile = "/tmp/" + id + ".avro";
				S3Object fullObject = s3client
						.getObject(new GetObjectRequest(Const.BUCKET_NAME, "wesley/avro/" + id + ".avro"));

				String targetFile = "wesley/avro/" + id + ".avro";
				Vehicle vehicle = null;
				try {
					DataFileStream<Vehicle> dataFileStream = new DataFileStream<Vehicle>(fullObject.getObjectContent(),
							userDatumReader);
					vehicle = dataFileStream.next(vehicle);
					Set<String> keys = vehicles.get(i).keySet();
					for (String key : keys) {
						if (key.equals("action")||key.equals("id")) {
							continue;
						}
						vehicle.put(key, vehicles.get(i).get(key));
					}
					vehicle.setIsin("AM10000000000" + i);
					Map<CharSequence, CharSequence> vdMap = vehicle.getVd();
					for (int k = 1; k <= 5; k++) {
						vdMap.put("VehicleData" + k, "VehicleDataChangeValue" + k);
					}
					vdMap.put("LOT_SIZE_A.dataFormat", "INT32");
					vehicle.setVd(vdMap);

					dataFileWriter.create(vehicle.getSchema(), new File(sourceFile));
					dataFileWriter.append(vehicle);
					dataFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				s3client.putObject(Const.BUCKET_NAME, targetFile, new File(sourceFile));
			}
			sum = vehicles.size();
		} else {
			int mid = vehicles.size() / 2;
			AvroUpdateTask leftTask = new AvroUpdateTask(vehicles.subList(1, mid));
			AvroUpdateTask rightTask = new AvroUpdateTask(vehicles.subList(mid + 1, vehicles.size()));

			leftTask.fork();
			rightTask.fork();

			int leftResult = (int) leftTask.join();
			int rightResult = (int) rightTask.join();
			sum = leftResult + rightResult;
		}

		return sum;
	}
}