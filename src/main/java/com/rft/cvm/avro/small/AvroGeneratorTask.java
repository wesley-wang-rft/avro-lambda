package com.rft.cvm.avro.small;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.rft.cvm.avro.Vehicle;
import com.rft.cvm.util.AWSCredentialsUtil;
import com.rft.cvm.util.Const;

public class AvroGeneratorTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 10;
	private List<JSONObject> vehicles;

	public AvroGeneratorTask(List<JSONObject> vehicles) {
		this.vehicles = vehicles;
	}

	protected Integer compute() {
		int sum = 0;
		boolean canCompute = vehicles.size() <= THRESHOLD;
		DatumWriter<Vehicle> userDatumWriter = new SpecificDatumWriter<Vehicle>(Vehicle.class);
		DataFileWriter<Vehicle> dataFileWriter = new DataFileWriter<Vehicle>(userDatumWriter);
		if (canCompute) {
			// remote
			AWSCredentials credentials = AWSCredentialsUtil.getAWSCredentials();
			AmazonS3 s3client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2)
					.build();
			for (int i = 0; i < vehicles.size(); i++) {
				// local
				// String sourceFile="result/"+i+"vehicle.avro";
				long id = vehicles.get(i).getLongValue("id");
				// remote-lamba
				String sourceFile = "/tmp/" + id + ".avro";
				// remote-java-main
				// String sourceFile="result/"+id+".avro";
				String targetFile = "wesley/avro/" + id + ".avro";
				Vehicle vehicle = new Vehicle();
				vehicle.setId(id);
				vehicle.setRic(vehicles.get(i).getString("ric"));
				vehicle.setSymbol(vehicles.get(i).getString("symbol"));
				vehicle.setDomain(vehicles.get(i).getString("domain"));
				vehicle.setDisplayName("NameABC" + id);
				vehicle.setExSourceCode("EX" + id % 100);
				vehicle.setVehicleGroupId(i % 100);
				vehicle.setIsin("XS10000000000" + i);
				vehicle.setEligibleSdi(1);
				vehicle.setEligibleTe(1);
				JSONObject vehicleData = vehicles.get(i).getJSONObject("VehicleData");
				if (vehicleData != null) {
					Map<CharSequence, CharSequence> vdMap = new HashMap<CharSequence, CharSequence>();
					Set<String> keys = vehicleData.keySet();
					for (String key : keys) {
						vdMap.put(key, vehicleData.getString(key));
					}
					vehicle.setVd(vdMap);
				}
				try {
					dataFileWriter.create(vehicle.getSchema(), new File(sourceFile));
					dataFileWriter.append(vehicle);
					dataFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// remote
				s3client.putObject(Const.BUCKET_NAME, targetFile, new File(sourceFile));
			}
			sum = vehicles.size();
		} else {
			int mid = vehicles.size() / 2;
			AvroGeneratorTask leftTask = new AvroGeneratorTask(vehicles.subList(1, mid));
			AvroGeneratorTask rightTask = new AvroGeneratorTask(vehicles.subList(mid + 1, vehicles.size()));
			leftTask.fork();
			rightTask.fork();

			int leftResult = (int) leftTask.join();
			int rightResult = (int) rightTask.join();
			sum = leftResult + rightResult;
		}

		return sum;
	}
}