package com.rft.cvm.avro.small;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class SmallAvroHandler implements RequestHandler<SQSEvent, Void> {

	private void buildAvro(List<JSONObject> addVehicle) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AvroGeneratorTask task = new AvroGeneratorTask(addVehicle);
		Integer r = forkJoinPool.invoke(task);
		System.out.println("total" + r);

	}

	private void updateAvro(List<JSONObject> updateVehicle) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AvroUpdateTask task = new AvroUpdateTask(updateVehicle);
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
		SmallAvroHandler handler = new SmallAvroHandler();
		List<SQSMessage> messages = new ArrayList<SQSMessage>();
		for (int i = 1; i <= 10; i++) {
			SQSMessage msg = new SQSMessage();
			long id = 816000000001l + i;
			//String input = "{\"id\":" + id+ ",\"action\":\"add\",\"ric\":\"ABC.BS\",\"domain\":\"MARKET_PRICE\",\"symbol\":\"ABC.BS\"}";
			String input = "{\"id\":" + id+ ",\"action\":\"update\",\"ric\":\"ABCa.BS\",\"domain\":\"MARKET_PRICE\",\"symbol\":\"ABCa.BS\"}";
			msg.setBody(input);
			messages.add(msg);
		}

		SQSEvent event = new SQSEvent();
		event.setRecords(messages);

		System.out.println("start:Time" + Calendar.getInstance().getTime());
		handler.handleRequest(event, null);
		System.out.println("finish:Time" + Calendar.getInstance().getTime());

	}

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		List<JSONObject> addVehicle = new ArrayList<JSONObject>();
		List<JSONObject> updateVehicle = new ArrayList<JSONObject>();
		if (event == null) {
			System.out.println("No Message in:");
			return null;
		}
		try {
			for (SQSMessage msg : event.getRecords()) {
				//System.out.println("Message Body is:" + msg.getBody());
				JSONObject rowVehicle = JSONObject.parseObject(msg.getBody());
				String action = rowVehicle.getString("action");
				if (action.equals("add")) {
					addVehicle.add(rowVehicle);
				} else if (action.equals("update")) {
					updateVehicle.add(rowVehicle);
				} else {
					System.out.println("No Action");
				}
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
			e.printStackTrace();
		}
		if (addVehicle.size() > 0) {
			buildAvro(addVehicle);
		}
		if (updateVehicle.size() > 0) {
			updateAvro(updateVehicle);
		}
		return null;
	}
}