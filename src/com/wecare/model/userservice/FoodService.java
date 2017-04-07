package com.wecare.model.userservice;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.entry.Food;

import recommSys.RecommSys;

public class FoodService extends UserService{

	public final String COLLECTION_NAME = "food";

	public Document insert(Food food) {
		// TODO Auto-generated method stub
		Document newDoc = null;
		if(food != null){
			newDoc = new Document("kind",  food.getKind())
				.append("categray", food.getCategray())
				.append("g", food.getG())
				.append("calorie", food.getCalorie())
				.append("userId", food.getUserId());
				
			connectDB(COLLECTION_NAME).insertOne(newDoc);
		}
		return newDoc;
	}
	
	public Food listAllFood(Food f){
		RecommSys sys = new RecommSys();
		return sys.match(f.getKind(), f.getG());
		
	}
	
}
