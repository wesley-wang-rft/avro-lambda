package com.rft.cvm.avro;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AvroGeneratorTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 10;
	private int start;
	private int end;

	public AvroGeneratorTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		DatumWriter<Vehicle> userDatumWriter = new SpecificDatumWriter<Vehicle>(Vehicle.class);
		DataFileWriter<Vehicle> dataFileWriter = new DataFileWriter<Vehicle>(userDatumWriter);
		if (canCompute) {
			//remote
			//AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
			for (int i = start; i <= end; i++) {
				// local 
				String sourceFile="result/"+i+"vehicle.avro";
				//remote
				//String sourceFile = "/tmp/wesleyavro/" + i + ".avro";
				String targetFile = "wesley/avro/" + i + ".avro";
				Vehicle vehicle = new Vehicle();
				vehicle.setId((long) i);
				vehicle.setRic("ABC" + i);
				vehicle.setSymbol("SymbolABC" + i);
				vehicle.setDomain("MARKET_PRICE");
				vehicle.setDisplayName("NameABC" + i);
				vehicle.setExSourceCode("EX" + i % 100);
				vehicle.setVehicleGroupId(i % 100);
				vehicle.setIsin("XS10000000000" + i);
				vehicle.setEligibleSdi(1);
				vehicle.setEligibleTe(1);
				Map<CharSequence,CharSequence> vdMap=new HashMap<CharSequence,CharSequence>();
				for(int k=1;k<=30;k++) {
					vdMap.put("VehicleData"+k, "VehicleDataValue"+k);
				}
				vdMap.put("LOT_SIZE_A.dataFormat", "INT16");
				vdMap.put("LOT_SIZE_A.value", "100");
				vehicle.setVd(vdMap);
				try {
					dataFileWriter.create(vehicle.getSchema(), new File(sourceFile));
					dataFileWriter.append(vehicle);
					dataFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//remote
				//s3client.putObject("a205419-evmdev-ll-bucket1", targetFile, new File(sourceFile));
			}
			sum = end - start + 1;
		} else {
			int mid = (start + end) / 2;
			AvroGeneratorTask leftTask = new AvroGeneratorTask(start, mid);
			AvroGeneratorTask rightTask = new AvroGeneratorTask(mid + 1, end);
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