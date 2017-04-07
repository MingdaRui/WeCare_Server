package com.wecare.model.userservice;

import org.apache.catalina.User;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.model.user.Users;
import com.wecare.model.user.Vendor;
import com.wecare.serviceInterface.UserServiceInterface;

public class VendorService extends UserService implements UserServiceInterface{

	public final String COLLECTION_NAME = "vendor";

	@Override
	public Document insert(Users u) {
		// TODO Auto-generated method stub
		Vendor vendor = (Vendor) u;
		Document newDoc = new Document("username", vendor.getUserName())
				.append("password", vendor.getPassword());
		connectDB(COLLECTION_NAME).insertOne(newDoc);
		return newDoc;   
	}

}
