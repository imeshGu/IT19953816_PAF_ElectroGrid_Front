package com.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class InterCommunicate {

	
	
	public String[] checkID(String id) {
		
		String[] account = {"",""};
		
		HttpURLConnection connection;
		try {
			URL url = new URL("http://localhost:8081/ElectroGrid/accounts/customer/?/searchCustomers");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); 
			connection.connect();
			
			int responseCode = connection.getResponseCode();//check whether connection is fine
			
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponseCode:" + responseCode);
			}
		else {
				StringBuilder inforString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					inforString.append(scanner.nextLine());
				}
				scanner.close();
				System.out.println(inforString);
				
				JSONArray array = new JSONArray(inforString); 
				JsonObject jobj = new JsonObject();
				
				int i=0;
				while(array.length()>i) {//looping  through json array and find a match with id
					String s = array.getString(i);
					jobj = new JsonParser().parse(s).getAsJsonObject(); //creating json object
					
					if(id==jobj.get("id").getAsString()) {//checking the input id with json object id 
						account[0] = jobj.get("name").getAsString();//if ids are matched breack the loop and return message
						account[1] = jobj.get("location").getAsString();
						break;
					}
					i++;
				}
				if(++i==array.length()) {
					return null;
				}
				//JSONParser parse = new JSONParser();
	            //JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(inforString));
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return account;
		
	}
	
}
