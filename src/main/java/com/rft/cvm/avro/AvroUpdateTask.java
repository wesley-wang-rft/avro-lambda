package com.rft.cvm.avro;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

public class AvroUpdateTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 10;
	private int start;
	private int end;

	public AvroUpdateTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		DatumWriter<Vehicle> userDatumWriter = new SpecificDatumWriter<Vehicle>(Vehicle.class);
		DataFileWriter<Vehicle> dataFileWriter = new DataFileWriter<Vehicle>(userDatumWriter);

		DatumReader<Vehicle> userDatumReader = new SpecificDatumReader<Vehicle>(Vehicle.class);
		if (canCompute) {
			// remote
			// AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
			for (int i = start; i <= end; i++) {
				// local
				String sourceFile = "result/" + i + "vehicle.avro";
				// remote
				// String sourceFile = "/tmp/wesleyavro/" + i + ".avro";
				String targetFile = "wesley/avro/" + i + ".avro";

				Vehicle vehicle = null;
				try {
					DataFileReader<Vehicle> dataFileReader = new DataFileReader<Vehicle>(new File(sourceFile),
							userDatumReader);

					vehicle = dataFileReader.next(vehicle);
					
					vehicle.setRic("Change_ABC" + i);
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
				// remote
				// s3client.putObject("a205419-evmdev-ll-bucket1", targetFile, new File(sourceFile));
			}
			sum = end - start + 1;
		} else {
			int mid = (start + end) / 2;
			AvroUpdateTask leftTask = new AvroUpdateTask(start, mid);
			AvroUpdateTask rightTask = new AvroUpdateTask(mid + 1, end);
			leftTask.fork();
			rightTask.fork();

			int leftResult = (int) leftTask.join();
			int rightResult = (int) rightTask.join();
			//System.out.println("finish Join: " + Thread.currentThread().getName());
			sum = leftResult + rightResult;
		}

		return sum;
	}
}