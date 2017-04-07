package com.wecare.model.userservice;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.model.user.Advertiser;
import com.wecare.model.user.Users;
import com.wecare.serviceInterface.UserServiceInterface;

public class AdvertiserService extends UserService implements UserServiceInterface{

	public final String COLLECTION_NAME = "advertiser";

	@Override
	public Document insert(Users u) {
		// TODO Auto-generated method stub
		Advertiser adv = (Advertiser) u;
		Document newDoc = new Document("username", adv.getUserName())
				.append("password", adv.getPassword());
		connectDB(COLLECTION_NAME).insertOne(newDoc);
		return newDoc;
	}

	
}
