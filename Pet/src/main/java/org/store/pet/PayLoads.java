package org.store.pet;

public class PayLoads {

	public static String getAddPetPayload(String petName, String id) {
		String addPetRequest = "{\r\n" + 
				"  \"id\": "+id+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+petName+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
		return addPetRequest;
	}
}
