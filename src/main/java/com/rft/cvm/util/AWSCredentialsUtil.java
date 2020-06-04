package com.rft.cvm.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

public class AWSCredentialsUtil {

	public static AWSCredentials getAWSCredentials() {
		AWSCredentials credentials = new BasicAWSCredentials("TEST",
				"TEST");
		return credentials;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
