package com.wecare.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

// This tutorial is from:
// mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/

public class QuickTour {

	public static void main(String[] args) {
		
		MongoClient mongoClient = new MongoClient( "localhost", 27017 );
//		You can specify the MongoClientURI connection string;
//		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
//		MongdaClient mongoClient = new MongoClient(connectionString);
		
		MongoDatabase testDatabase = mongoClient.getDatabase("test");
		
		MongoCollection<Document> testCollection = testDatabase.getCollection("testCollection");
		
//		{
//			"name" : "MongoDB",
//			"type" : "database",
//			"count" : 1,
//			"versions": [ "v3.2", "v3.0", "v2.6" ],
//			"info" : { x : 203, y : 102 }
//		}		
		Document testDoc = new Document("name", "MongoDB")
						.append("type", "database")
						.append("count", 1)
						.append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
						.append("info", new Document("x", 203).append("y", 102));
		//testCollection.insertOne(testDoc);
		
//		{ "i" : value }
		List<Document> multiDocs = new ArrayList<Document>();
		for (int i = 0; i < 100; i++) {
			multiDocs.add(new Document("i", i));
		}
		//testCollection.insertMany(multiDocs);
		
		// Count Documents in A Collection
		System.out.println(testCollection.count());
		
		// Find the First Document in a Collection
		Document myDoc = testCollection.find().first();
		System.out.println(myDoc.toJson());	
		
		// Find All Documents in a Collection
//		MongoCursor<Document> cursor = testCollection.find().iterator();
//		try {
//			while (cursor.hasNext()) {
//				System.out.println(cursor.next().toJson());
//			}
//		} finally {
//			cursor.close();
//		}
		
		// Get A single Document That matches a Filter 
		myDoc = testCollection.find(eq("i", 71)).first();
		System.out.println(myDoc.toJson());
		
		// Get All Documents That Match a Filter
		// The following example returns and prints all documents where "i" > 50:
		Block<Document> printBlock = new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document.toJson());
			}
		};
		//testCollection.find(gt("i", 50)).forEach(printBlock);
		
		testCollection.find(and(gt("i", 50), lte("i", 60))).forEach(printBlock);
		
	}	
	
}
