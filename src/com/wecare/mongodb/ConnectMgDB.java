package com.wecare.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

public class ConnectMgDB {
	
	MongoClient wcMgClient;
	
	public void connectToMgDB() {
		
//		wcMgClient = new MongoClient( "10.6.44.179", 27017 );
//		wcMgClient = new MongoClient( "172.17.0.1", 27017 );
		wcMgClient = new MongoClient("127.0.0.1", 27017);
//		You can specify the MongoClientURI connection string;
		//MongoClientURI connectionString = new MongoClientURI("10.6.44.179:27017");
		//wcMgClient = new MongoClient(connectionString);
	
		MongoDatabase wecaredb = wcMgClient.getDatabase("wecaredb");
	
		MongoCollection<Document> user = wecaredb.getCollection("user");
	
//		Test if the Collection is empty, then initial the Collection
		Document myDoc = user.find().first();
		
		if(myDoc == null) {
			System.out.println("There is no document in the current collection"); 	
			new InitTestData().initTestMgDB(wcMgClient);	
		}
	
	}
	
	public MongoClient getMgClient() {
		return wcMgClient;
	}
}