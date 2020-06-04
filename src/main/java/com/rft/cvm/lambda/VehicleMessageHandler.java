package com.rft.cvm.lambda;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class VehicleMessageHandler implements RequestHandler<SQSEvent, Void> {

	public Void handleRequest(SQSEvent event, Context context) {
		List<SQSMessage> allVehicleMessage = event.getRecords();
		for (SQSMessage msg : allVehicleMessage) {
			
			System.out.println(new String(msg.getBody()));
		}
		return null;
	}

}
