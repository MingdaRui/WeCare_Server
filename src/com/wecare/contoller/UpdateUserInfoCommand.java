package com.wecare.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.wecare.model.user.*;
import com.wecare.model.userservice.UserService;

import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.*;

public class UpdateUserInfoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String forwardToJsp = "";
		
		String usertype;
		String username;
		String password;
		
		String sourcePage;
		
		String elementIdName = "";
		int elementIdValue = 0;
		
		Users users = null;
		
		username = request.getParameter("ud_username");
		password = request.getParameter("ud_password");
		usertype = request.getParameter("usertype");
		
		sourcePage = request.getParameter("sourcePage");
		
		System.out.println(
//				"UpdateUserInfoCommand.java - execute(): \n" 
//				+ 
				"usertype: " + usertype
				);
		
		if(usertype.equals("advertiser")) {
			
			System.out.println(
//					"UpdateUserInfoCommand.java - execute(): "
//					+ 
					"Entry if(usertype == \"advertiser\")\n"
					);
			
			int ad_id;
			String ad_title;
			String ad_description;
			
			ad_id = Integer.parseInt( request.getParameter("ud_ad_id") );
			ad_title = request.getParameter("ud_ad_title");
			ad_description = request.getParameter("ud_ad_description");
			
//			users = new Advertiser(username, password, 1, ad_title, ad_description);
			users = new Advertiser(username, password, ad_id, ad_title, ad_description);
			users.setUserType(usertype);
			
			elementIdName = "ad_id";
			elementIdValue = ad_id;
			
//			UserService userService = new UserService();
//			userService.UpdateUserInfo(usertype, users);
			
		} else if(usertype.equals("nutritionist")) {
			
			int dietary_id;
			String dietary_title;
			String dietary_type;
			String dietary_content;
			
			dietary_id = Integer.parseInt( request.getParameter("ud_dietary_id") );
			dietary_title = request.getParameter("ud_dietary_title");
			dietary_type = request.getParameter("ud_dietary_type");
			dietary_content = request.getParameter("ud_dietary_content");
			
			users = new Nutritionist(username, password, dietary_id, dietary_title, dietary_type, dietary_content);
			users.setUserType(usertype);
			
			elementIdName = "dietary_id";
			elementIdValue = dietary_id;
						
		} else if(usertype.equals("vendor")) {
			
			int product_id;
			String product_name;
			String product_price;
			String product_description;
			
			product_id = Integer.parseInt( request.getParameter("ud_product_id") );
			product_name = request.getParameter("ud_product_name");
			
			System.out.println("vendor.product_name = " + product_name);
			
			product_price = request.getParameter("ud_product_price");
			product_description = request.getParameter("ud_product_description");
			
			users = new Vendor(username, password, product_id, product_name, product_price, product_description);
			users.setUserType(usertype);
			
			Vendor v = (Vendor) users;
			System.out.println(
					"UpdateUserInfoCommand.java - UpdateUserInfo()\n"
					+ "usertype == \"vendor\"\n" 
					+ "vendor.getUserName(): " + v.getUserName() + "\n"
					+ "vendor.getPassword(): " + v.getPassword() + "\n"
					+ "vendor.getProduct_id(): " + v.getProduct_id() + "\n"
					+ "vendor.getProduct_name(): " + v.getProduct_name() + "\n"
					+ "vendor.getProdutc_price(): " + v.getProduct_price() + "\n"
					+ "vendor.getProduct_description(): " + v.getProduct_description() + "\n");
			
			elementIdName = "product_id";
			elementIdValue = product_id;
			
		}
		
		UserService userService = new UserService();
//		
//		Advertiser a = (Advertiser) users;
//		if(a == null || users == null) {
//			System.out.println("UpdateUserInfoCommand.java - execute(): a!=null && users != null");
//		}
//		System.out.println("UpdateUserInfoCommand.java - execute()\n"
//				+ "advertiser.getUserName(): " + a.getUserName() + "\n"
//				+ "advertiser.getPassword(): " + a.getPassword() + "\n"
//				+ "advertiser.getAd_id(): " + a.getAd_id() + "\n"
//				+ "advertiser.getAd_title(): " + a.getAd_title() + "\n"
//				+ "advertiser.getAd_description(): " + a.getAd_description());
//				
		
//		Document findUserName = userService.connectDB(users.getUserType()).find(eq("username", users.getUserName())).first();
		Document findElementNameId = userService.connectDB(users.getUserType()).find(and( eq("username", users.getUserName()), eq(elementIdName, elementIdValue))).first();

		System.out.println("UpdateUserInfoCommand.java - execute(): For findElementNameId, \n"
				+ "users.getUserType(): " + users.getUserType() + "\n"
				+ "username: " + users.getUserName() + "\n"
				+ "elementIdName: " + elementIdName + "\n"
				+ "elementIdValue: " + elementIdValue + "\n");
		
		Document findUserName = userService.connectDB(users.getUserType()).find(eq("username", users.getUserName())).first();
		Document findElementId = userService.connectDB(users.getUserType()).find(eq(elementIdName, elementIdValue)).first();
		System.out.println("UpdateUserInfoCommand.java - execute(): \n"
				+ "elementIdName: " + elementIdName + "\n"
				+ "elementIdValue: " + elementIdValue
				);
		if(findUserName != null) {
			System.out.println("findUserName: " + findUserName.toJson() + "\n");
		}
		if(findElementId != null) {
			System.out.println("findElementId: " + findElementId.toJson() + "\n");
		}
			
		if(findElementNameId != null) {
			
			System.out.println("UpdateUserInfoCommand.java - execute(): \n"
					+ "findElementNameId: " + findElementNameId.toJson() + "\n");
			
			userService.UpdateUserInfo(usertype, users, elementIdName, elementIdValue);
			
		} else {
			userService.InsertUserInfo(usertype, users);
		}
		
//		if(sourcePage.equals("/AdminHome2.jsp")) {
//			forwardToJsp = "/AdminHome.jsp";
//		} else {
//			forwardToJsp = sourcePage;
//		}
		forwardToJsp = sourcePage;
		
		return forwardToJsp;
	}

}



























