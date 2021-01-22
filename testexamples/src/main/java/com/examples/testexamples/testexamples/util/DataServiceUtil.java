package com.examples.testexamples.testexamples.util;

import java.util.UUID;

public class DataServiceUtil {
	
	public static String generateUniqueId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
