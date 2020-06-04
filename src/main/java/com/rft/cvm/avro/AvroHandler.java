package com.rft.cvm.avro;

import java.util.Calendar;
import java.util.concurrent.ForkJoinPool;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import com.amazonaws.services.lambda.runtime.Context;

public class AvroHandler {
	public String handleRequest(String action, int min, int max, Context context) {

		if (action.equals("create")) {
			buildAvro(min, max);
		} else if(action.equals("update")){
			updateAvro(min,max);
		}
		return "success";

	}

	private void buildAvro(int min, int max) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AvroGeneratorTask task = new AvroGeneratorTask(min, max);
		Integer r = forkJoinPool.invoke(task);
		System.out.println("total" + r);

	}

	private void updateAvro(int min, int max) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AvroUpdateTask task = new AvroUpdateTask(min, max);
		Integer r = forkJoinPool.invoke(task);
		System.out.println("total_update" + r);
	}

	static String buildSchema() {
		Schema vehicleSchema = SchemaBuilder.record("Vehicle").namespace("com.rft.cvm.avro").fields().requiredLong("id")
				.requiredString("ric").requiredString("symbol").requiredString("domain").requiredString("exSourceCode")
				.requiredInt("vehicleGroupId").requiredString("displayName").requiredString("isin")
				.requiredInt("eligibleTe").requiredInt("eligibleSdi").endRecord();
		return vehicleSchema.toString();
	}

	public static void main(String[] args) {
		AvroHandler handler = new AvroHandler();
		 System.out.println("start:Time"+Calendar.getInstance().getTime());
		//handler.handleRequest("create", 450001, 1450000, null);
		handler.handleRequest("update", 250001, 255000, null);
		System.out.println("finish:Time"+Calendar.getInstance().getTime());
		// System.out.println(AvroHandler.buildSchema());
		// TODO Auto-generated method stub

	}
}