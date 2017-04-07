package com.wecare.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.wecare.model.userservice.UserService;

public class SearchUserCommand implements Command {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String forwardToJsp = "";
		
		String username;
		String usertype;
		String elementid;

		username = request.getParameter("username");
		usertype = request.getParameter("usertype");
		elementid = request.getParameter("elementid");
		
		UserService userService = new UserService();
		FindIterable<Document> docs = userService.searchById(username, elementid, usertype);
		request.setAttribute("searchResultLists", docs);
		forwardToJsp = "/AdminHome2.jsp";
		
	
		return forwardToJsp;
	}

}
