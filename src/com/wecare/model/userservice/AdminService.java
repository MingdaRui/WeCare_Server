package com.wecare.model.userservice;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.model.user.Admin;
import com.wecare.model.user.Users;
import com.wecare.serviceInterface.UserServiceInterface;

public class AdminService extends UserService implements UserServiceInterface{
	
	public final String COLLECTION_NAME = "admin";
	
	@Override
	public Document insert(Users admin) {
		// TODO Auto-generated method stub
		//Admin admin = (Admin) u;
		Document newDoc = null;
		if(checkUserName(admin.getUserName()) == false){
		newDoc = new Document("username", admin.getUserName())
				.append("password", admin.getPassword());
		connectDB(COLLECTION_NAME).insertOne(newDoc);
		}
		return newDoc;
	}
	
	public boolean checkUserName(String username){

        Document filter = new Document();  
        filter.append("username", username);  
        FindIterable<Document> results = connectDB(COLLECTION_NAME).find(filter);  
		MongoCursor<Document> mongoCursor = results.iterator();  

        if(mongoCursor.hasNext()){
        	return true;
        }
        
        return false;
	}
	
	

}
