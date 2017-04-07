package com.wecare.model.userservice;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import com.wecare.model.user.*;
import com.wecare.mongodb.ConnectMgDB;

import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;

import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;


public class UserService {
	
	private MongoClient m = null;
	private MongoDatabase w = null;
	private MongoCollection<Document> docs = null;
	
	public MongoCollection<Document> connectDB(String COLLECTION_NAME){
		ConnectMgDB c = new ConnectMgDB();
		c.connectToMgDB();
		
	    m = c.getMgClient();
	    w = m.getDatabase("wecaredb");
		docs = w.getCollection(COLLECTION_NAME);
		
		return docs;
	}

	
	
	public Document findUserByUsernamePassword(String username, String password, String COLLECTION_NAME) {
		// TODO Auto-generated method stub  
		Document find = new Document("username", username)
				.append("password", password);
		
		FindIterable<Document> findIterable = connectDB(COLLECTION_NAME).find(find);  
		
		MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
           return mongoCursor.next();
        }  
		
		return null;
	}
	
	
	// Search users by collection name, that is display the entire colletion.
	public FindIterable<Document> searchByUsers(String COLLECTION_NAME) {
		// TODO Auto-generated method stub  
		
		System.out.println("UserService.java - searchByUsers: "
				+ "Entry searchByUsers(String " + COLLECTION_NAME + "){}");
		
		FindIterable<Document> findIterable = connectDB(COLLECTION_NAME).find();
		
		if(findIterable != null) {
		
			MongoCursor<Document> mongoCursor = findIterable.iterator();  
			Document details = null;
			while(mongoCursor.hasNext()){ 
				details = mongoCursor.next();
				System.out.println("UserService.java - searchByUsers: " + details.size());
				System.out.println("System.out.println: " + details);
			}

			return findIterable;
			
		} else {
			return findIterable;
		}
	}
	
	
	public FindIterable<Document> searchById(String username, String elementid, String usertype) {
		
		FindIterable<Document> findIterable;
		String elementKeyName;
		
//		System.out.println("UserService.java - searchById: \n"
//				+ "username: " + username + "\n"
//				+ "elementid: " + elementid + "\n"
//				+ "usertype: " + usertype);
		
		if(usertype.equals("advertiser")) {
			elementKeyName = "ad_id";
			
			System.out.println("UserService.java - searchById\n"
					+ "elementKeyName = \"ad_id\"");
			
		} else if(usertype.equals("vendor")) {
			elementKeyName = "product_id";
		} else if(usertype.equals("nutritionist")) {
			elementKeyName = "dietary_id";
		} else {
			elementKeyName = null;
		}
		
		if( !username.isEmpty() && !elementid.isEmpty() ) {
			findIterable = connectDB(usertype).find(and(eq("username", username), eq(elementKeyName, elementid)));
	
			System.out.println("UserService.java - searchById: \n"
					+ "1. username!=null, elementid!=null : " 
					//+ connectDB(usertype).find(eq(elementKeyName, elementid)).first()
					+ connectDB(usertype).find(or(eq("username", username), eq(elementKeyName, elementid))).first());
			
		} else if( !username.isEmpty() ) {
			findIterable = connectDB(usertype).find(eq("username", username));
			
			System.out.println("UserService.java - searchById: \n"
					+ "2. elementid.equals(null) : " + connectDB(usertype).find(eq("username", username)).first());
		
		} else if( !elementid.isEmpty() ) {
			findIterable = connectDB(usertype).find(eq(elementKeyName, elementid));
			
			System.out.println("UserService.java - searchById: \n"
					+ "3. username.equals(null) : " + connectDB(usertype).find(eq(elementKeyName, elementid)).first());
			
		} else { 
			findIterable = null; 
		
			System.out.println("UserService.java - searchById: \n "
				+ "4. username == null, elementid == null");
		
		}
		
		return findIterable;
	}
	
	
	public DeleteResult deleteByObjId(String COLLECTION_NAME, String deleteId){
		
		System.out.println("UserService.java - deleteByObjId():\n"
				+ "deleteOne( new Document(\"_id\", new ObjectId(deleteId) ) ): " + new Document("_id", new ObjectId(deleteId)).toJson() + "\n");
		
		return connectDB(COLLECTION_NAME).deleteOne(new Document("_id", new ObjectId(deleteId)));
		
	}
	
	
	public boolean UpdateUserInfo(String usertype, Users users, String elementIdName, int elementIdValue) {
		
		System.out.println("UserService.java - UpdateUserInfo()\n"
				+ "advertiser.getUserName(): " + users.getUserName() + "\n"
				+ "advertiser.getPassword(): " + users.getPassword());
		
		String userType = usertype;
		Document updateDoc;
		
		if(usertype.equals("advertiser")) {
			
			System.out.println(
//					"UserService.java - UpdateUserInfo()\n"
//					+ 
					"Entry usertype.equals(\"advertiser\")"
					);
			
			Advertiser advertiser = (Advertiser) users;			
			System.out.println(
//					"UserService.java - UpdateUserInfo()\n"
//					+ 
					"advertiser.getUserName(): " + advertiser.getUserName() + "\n"
					+ "advertiser.getPassword(): " + advertiser.getPassword() + "\n"
					+ "advertiser.getAd_id(): " + advertiser.getAd_id() + "\n"
					+ "advertiser.getAd_title(): " + advertiser.getAd_title() + "\n"
					+ "advertiser.getAd_description(): " + advertiser.getAd_description() + "\n");
			
			updateDoc = new Document("username", advertiser.getUserName())
					.append("password", advertiser.getPassword())
					.append("ad_id", advertiser.getAd_id())
					.append("ad_title", advertiser.getAd_title())
					.append("ad_description", advertiser.getAd_description());
			
//			connectDB(usertype).updateOne( eq("username",advertiser.getUserName()), newDoc );
			connectDB(usertype).updateOne( 
					and( eq("username", advertiser.getUserName()),eq(elementIdName, elementIdValue) ), 
					new Document("$set", updateDoc) );
			
		} else if(usertype.equals("nutritionist")) {
			
			Nutritionist nutritionist = (Nutritionist) users;

			updateDoc = new Document("username", nutritionist.getUserName())
					.append("password", nutritionist.getPassword())
					.append("dietary_id", nutritionist.getDietary_id())
					.append("dietary_type", nutritionist.getDietary_type())
					.append("dietary_title", nutritionist.getDietary_title())
					.append("dietary_content", nutritionist.getDietary_content());
			
			connectDB(usertype).updateOne(
					and( eq("username", nutritionist.getUserName()), eq(elementIdName, elementIdValue) ), 
					new Document("$set", updateDoc));
			
		} else if(usertype.equals("vendor")) {
			
			Vendor vendor = (Vendor) users;
			
			updateDoc = new Document("username", vendor.getUserName())
					.append("password", vendor.getPassword())
					.append("product_id", vendor.getProduct_id())
					.append("product_name", vendor.getProduct_name())
					.append("product_price", vendor.getProduct_price())
					.append("product_description", vendor.getProduct_description());
			
			connectDB(usertype).updateOne(
					and( eq("username", vendor.getUserName()), eq(elementIdName, elementIdValue) ), 
					new Document("$set", updateDoc));
			
		} else { }
		
		return true;
		
	}
	
	
	public void InsertUserInfo(String usertype, Users users) {
		
		String userType = usertype;
		Document insertDoc;
		
		if(usertype.equals("advertiser")) {
			
			Advertiser advertiser = (Advertiser) users;
			
			insertDoc = new Document("username", advertiser.getUserName())
					.append("password", advertiser.getPassword())
					.append("ad_id", advertiser.getAd_id())
					.append("ad_title", advertiser.getAd_title())
					.append("ad_description", advertiser.getAd_description());
			
			connectDB(usertype).insertOne(insertDoc);
			
		} else if(usertype.equals("nutritionist")) {
			
			Nutritionist nutritionist = (Nutritionist) users;
			
			insertDoc = new Document("username", nutritionist.getUserName())
					.append("password", nutritionist.getPassword())
					.append("dietary_id", nutritionist.getDietary_id())
					.append("dietary_title", nutritionist.getDietary_title())
					.append("dietary_type", nutritionist.getDietary_type())
					.append("dietary_content", nutritionist.getDietary_content());
			
			connectDB(usertype).insertOne(insertDoc);
			
		} else if(usertype.equals("vendor")) {
			
			Vendor vendor = (Vendor) users;
			
			insertDoc = new Document("username", vendor.getUserName())
					.append("password", vendor.getPassword())
					.append("product_id", vendor.getProduct_id())
					.append("product_name", vendor.getProduct_name())
					.append("Product_price", vendor.getProduct_price())
					.append("product_description", vendor.getProduct_description());
			
			connectDB(usertype).insertOne(insertDoc);
			
		} else { }
		
	}
	/*public Boolean userValidate(Users user) {
		
		ConnectMgDB c = new ConnectMgDB();
		c.connectToMgDB();
	    m = c.getMgClient();
	    w = m.getDatabase("wecaredb");
		u = w.getCollection(COLLECTION_NAME);
		
		String username = user.getUserName();
		String password = user.getPassword();

		Document myDoc = u.find(eq("username", username)).first();
		System.out.println(myDoc.toJson());
		
		return true;
	}*/
	
	

}
