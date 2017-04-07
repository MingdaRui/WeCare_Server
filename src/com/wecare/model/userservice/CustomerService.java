package com.wecare.model.userservice;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.model.user.Customer;

public class CustomerService extends UserService{

	public final String COLLECTION_NAME = "customer";

	public Document insert(Customer customer) {
		// TODO Auto-generated method stub
		Document newDoc = null;
		if(checkUserName(customer.getUsername()) == false && checkEmptyUsernamePassword(customer) == false){
			newDoc = new Document("username", customer.getUsername())
				.append("password", customer.getPassword())
				.append("email", customer.getEmail())
				.append("userGoal", customer.getUserGoal())
				.append("gender", customer.getGender())
				.append("dayOfBirth", customer.getDayOfBirth())
				.append("country", customer.getCountry())
				.append("height", customer.getHeight())
				.append("weight", customer.getWeight())
				.append("goalOfWeight", customer.getGoalOfWeight())
				.append("weeklyGoal", customer.getWeeklyGoal());
			connectDB(COLLECTION_NAME).insertOne(newDoc);
		}
		return newDoc;
	}
	
	public boolean checkEmptyUsernamePassword(Customer customer){
		if(customer.getUsername() == null || customer.getUsername().equals("") || 
				customer.getPassword() == null || customer.getPassword().equals("") 
				|| customer.getEmail() == null || customer.getEmail().equals("")){
			return true;
		}
		return false;	
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
	public String getCustomerIdByUsername(String username){

        Document filter = new Document();  
        filter.append("username", username);  
        FindIterable<Document> results = connectDB(COLLECTION_NAME).find(filter);  
        MongoCursor<Document> mongoCursor = results.iterator();  
        String _id = "";
        if(mongoCursor.hasNext()){
        	Document document = mongoCursor.next();
        	_id = document.get("_id").toString();
        }
        
        return _id;
	}
	
}
