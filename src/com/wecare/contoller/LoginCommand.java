package com.wecare.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.wecare.model.userservice.AdminService;
import com.wecare.model.userservice.UserService;

public class LoginCommand implements Command{

    /**
    *   This command allows a user to log in 
    *   the system. The method calls the login DAO 
    *   method through the UserService to check if the 
    *   username and password are correct
    *
    *   @param request current servlet request
    *   @param response current servlet response
    *   @return String of the forward file : <br/>
    */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("usertype");
    
        HttpSession session = request.getSession();
        
        if (username != null && password != null) {
        	
        	UserService userService = new UserService();
        	Document document = userService.findUserByUsernamePassword(username, password, type);
        	
        	String clientSessionId = session.getId();
            session.setAttribute("loggedSessionId", clientSessionId);
        	              
        	if(document != null){
            	session.setAttribute("userObj", document);

	            switch (type) {
	            
				case "admin":
					forwardToJsp = "/UserPage.jsp";
					break;
					
//				case "advertiser":
//					forwardToJsp = "/AdvertiserHome.jsp";
//					break;
//					
//				case "nutritionist":
//					forwardToJsp = "/NutritionistHome.jsp";
//					break;
//					
//				case "vendor":
//					forwardToJsp = "/VendorHome.jsp";
//					break;
					
				default:
					break;
				}
	            
                if(type.equals("advertiser") || type.equals("nutritionist") || type.equals("vendor")) {
                	
                    session.setAttribute("usertype", type);
                    session.setAttribute("try", "success!");
                	request.setAttribute("action", "processGuestUsers");
                	
                	RequestDispatcher rd = request.getRequestDispatcher("userActionServlet");
                    try {
						rd.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                
        	} else {
        		session.setAttribute("erroMsg","Username or password is not correct");
        		forwardToJsp = "/Login.jsp";
        	}	
        
        }
        
        return forwardToJsp;
    }  
}







