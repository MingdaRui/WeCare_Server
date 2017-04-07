package com.wecare.model.userservice;

import org.bson.Document;

import com.wecare.model.user.Nutritionist;
import com.wecare.model.user.Users;
import com.wecare.serviceInterface.UserServiceInterface;

public class NutritionistService extends UserService implements UserServiceInterface{
	public final String COLLECTION_NAME = "nutritionist";

	@Override
	public Document insert(Users u) {
		// TODO Auto-generated method stub
		Nutritionist nut = (Nutritionist) u;
		Document newDoc = new Document("username", nut.getUserName())
				.append("password", nut.getPassword());
		connectDB(COLLECTION_NAME).insertOne(newDoc);
		return newDoc;   
	}

	
}
