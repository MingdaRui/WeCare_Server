package com.wecare.contoller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.wecare.model.userservice.UserService;

public class DisplayUpdateFormsByUsertype implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String forwardToJsp = "";
		Set<String> keySet;
		
		String action = request.getParameter("action");
		String usertype = request.getParameter("usertype");
		
		System.out.println("DisplayUpdateFormsByUserType.java - execute() : \n"
				+ "request.getParameter(\"action\") : " + action + "\n"
				+ "request.getParameter(\"usertype\") : " + usertype);
				
		UserService userService = new UserService();	
		Document details = userService.searchByUsers(usertype).first();
		
		if(details != null) {
			keySet = details.keySet();
		} 
		else {
			keySet = null;
		}
		
		request.setAttribute("keySet", keySet);
		request.setAttribute("usertype", usertype);
		
		forwardToJsp = "/AdminHome2.jsp";
		
		return forwardToJsp;

	}
	

}
