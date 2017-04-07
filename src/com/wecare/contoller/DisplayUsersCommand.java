package com.wecare.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.wecare.model.userservice.UserService;

public class DisplayUsersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String forwardToJsp = "";
		
        HttpSession session = request.getSession();

        String clientSessionId = session.getId();
        String storedSessionId = (String) session.getAttribute("loggedSessionId");

        String type = request.getParameter("type");
        
        System.out.println("DisplayUserCommand.java - request.getParameter(\"type\"): " + type + "\n");
//        System.out.println("DisplayUserCommand.java - request.getParameter(\"usertype\"): " + request.getParameter("usertype"));
        
        if(clientSessionId.equals(storedSessionId)) {
        	
        	UserService userService = new UserService();
        	FindIterable<Document> docs = userService.searchByUsers(type);
            session.setAttribute("userlists", docs);
            session.setAttribute("usertype", type);
//            forwardToJsp = "/DisplayUserList.jsp";
            forwardToJsp = "/UserPage1.jsp";

        }
				
	    return forwardToJsp;
	}

}









