package com.wecare.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.result.DeleteResult;
import com.wecare.model.userservice.UserService;
import static com.mongodb.client.model.Filters.*;

public class DeleteByIDCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String forwardToJsp = "";
		String sourcePage = request.getParameter("sourcePage");
		String deleteId = request.getParameter("deleteId");
        String type = request.getParameter("usertype");
        
        
        System.out.println("DeleteByIDCommand.java - execute():\n"
        		+ "request.getParameter(\"sourcePage\"): " + sourcePage +"\n"
        		+ "request.getParameter(\"deleteId\"): " + deleteId + "\n"
        		+ "request.getParameter(\"usertype\"): " + type);
        UserService u = new UserService();
        if(u.connectDB(type).find( eq("_id", deleteId) ).first() != null ) {
        	System.out.println("deletedUserInfo:\n "
        			+ u.connectDB(type).find( eq("_id", deleteId) ).first().toJson() + "\n");
        } else {
        	System.out.println("deleteUserInfo: null\n");
        }

        
        if(sourcePage.equals("/AdvertiserHome.jsp")) {
        	request.setAttribute("action", "processGuessUsers");
        }
        
        HttpSession session = request.getSession();

        String clientSessionId = session.getId();
        String storedSessionId = (String) session.getAttribute("loggedSessionId");
        
         if(clientSessionId.equals(storedSessionId) || request.getAttribute("action") != null) {
        	 
        	 UserService userService = new UserService();
        	 DeleteResult result = userService.deleteByObjId(type, deleteId);
        	 
        	 if(result.getDeletedCount() > 0){
//        		 forwardToJsp = "/DisplayUserList.jsp";
//        		 forwardToJsp = "/AdminHome2.jsp";
        		 System.out.println("DeleteByIDCommand.java - execute():\n"
        		 		+ "result.getDeletedCount() > 0: sourcePage == " + sourcePage + "\n");
        		 
        		 forwardToJsp = sourcePage;
        	 }
        }
        
		return forwardToJsp;
	}

}











