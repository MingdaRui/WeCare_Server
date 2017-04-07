package com.wecare.entry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*; // Package for eq("String", "String");
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import com.wecare.mongodb.ConnectMgDB;

import java.util.ArrayList;
import java.util.List;

public class Go {
	
	public static void main(String[] args) {
		Go g = new Go();
		g.startMgDB();
		
	}
	
	public void startMgDB() {
		
		ConnectMgDB c = new ConnectMgDB();
		c.connectToMgDB();
		MongoClient m = c.getMgClient();
		MongoDatabase w = m.getDatabase("wecaredb");
		MongoCollection<Document> u = w.getCollection("user");

		// Show all the documents current in the collection
		MongoCursor<Document> cursor = u.find().iterator();

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
		
		System.out.println(u.count());
		
	}
}
