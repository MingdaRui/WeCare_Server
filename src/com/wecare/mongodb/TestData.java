package com.wecare.mongodb;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;


public class TestData {
	
//	{ 
//		"username" : "jane", 
//		"password" : "1234", 
//		"email" : "1234@hotmail.com", 
//		"userGoal" : "loseWeight", 
//		"dayOfBirth" : 1485469612484, 
//		"country" : "China", 
//		"height" : 12.06, 
//		"weight" : 14.44, 
//		"goalOfWeight" : 33.22, 
//		"weeklyGoal" : 0.11 
//	}
	
	Document testDoc1 = new Document("username", "sijia")
			.append("password", "1234")
			.append("email", "1234@hotmail.com")
			.append("userGoal", "loseWeight")
			.append("dayOfBirth", "19921111")
			.append("country", "China")
			.append("height", 162.06)
			.append("weight", 44.44)
			.append("goalOfWeight", 3.22)
			.append("weeklyGoal", 0.11);
	
	Document testDoc2 = new Document("username", "mingda")
			.append("password", "1234")
			.append("email", "mingdarui@gmail.com")
			.append("userGoal", "loseWeight")
			.append("dayOfBirth", "19931231")
			.append("country", "China")
			.append("height", 186.00)
			.append("weight", 75.44)
			.append("goalOfWeight", 5.22)
			.append("weeklyGoal", 0.11);
	
	Document testDoc3 = new Document("username", "yueming")
			.append("password", "1234")
			.append("email", "yzh@gmail.com")
			.append("userGoal", "loseWeight")
			.append("dayOfBirth", "19940202")
			.append("country", "China")
			.append("height", 160.06)
			.append("weight", 65.44)
			.append("goalOfWeight", 10.22)
			.append("weeklyGoal", 0.11);
	
	Document testDoc4 = new Document("username", "yingwang")
			.append("password", "1234")
			.append("email", "ywan@gmail.com")
			.append("userGoal", "loseWeight")
			.append("dayOfBirth", "19921212")
			.append("country", "China")
			.append("height", 160.06)
			.append("weight", 60.44)
			.append("goalOfWeight", 10.22)
			.append("weeklyGoal", 0.11);
	
	public List<Document> getAllTestData() {
		List<Document> documents = new ArrayList<Document>();
		documents.add(testDoc1);
		documents.add(testDoc2);
		documents.add(testDoc3);
		documents.add(testDoc4);
		return documents;
	}
}
