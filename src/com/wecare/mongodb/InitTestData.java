package com.wecare.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;


public class InitTestData {

	public void initTestMgDB(MongoClient wcMgClient) {
		System.out.println("Simulating the data initialling process");
		
		MongoDatabase wecaredb = wcMgClient.getDatabase("wecaredb");
		
		MongoCollection<Document> user = wecaredb.getCollection("user");
		
		TestData td = new TestData();
		user.insertMany(td.getAllTestData());
	}
}
