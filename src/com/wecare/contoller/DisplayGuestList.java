package com.wecare.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.wecare.model.userservice.UserService;

public class DisplayGuestList implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String forwardToJsp = "";
		FindIterable<Document> findIterable;
		
		String usertype = (String) session.getAttribute("usertype");
		Document userObj;
		
		userObj = (Document) session.getAttribute("userObj");
		System.out.println("DisplayGuestList.java - execute \n"
				+ "request.getAttribute(\"usertype\"): " + usertype + "\n"
				+ "request.getAttribute(\"userObj\"): " + userObj.toJson() + "\n");
		
		String clientSessionId = session.getId();
        String storedSessionId = (String) session.getAttribute("loggedSessionId");
		
        if( clientSessionId.equals(storedSessionId) ) {
        	UserService userservice = new UserService();
        	findIterable = userservice.searchById(userObj.getString("username"), "", usertype);
		
        	session.setAttribute("findByUsername", findIterable);
        	
        	if(usertype.equals("advertiser")) {
    			forwardToJsp = "/AdvertiserHome.jsp";
    		} else if(usertype.equals("nutritionist")) {
    			forwardToJsp = "/NutritionistHome.jsp";
    		} else if(usertype.equals("vendor")) {
    			forwardToJsp = "/VendorHome.jsp";
    		} else {
    			forwardToJsp = null;
    		}
        }
//		return "/AdminHome.jsp";
		System.out.println("DisplayGuestList.java - execute(): \n"
				+ "forwardToJsp: " + forwardToJsp + "\n");
		
		return forwardToJsp;
		
	}

}

















