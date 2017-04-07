package com.wecare.controller.Login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wecare.model.user.*;
import com.wecare.model.userservice.UserService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException { 
        
    	/*String userType = request.getParameter("usertype");
    	String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserService u = new UserService();
        
        Users user = u.createNewUsr("usertype");
        user.setUserName(userName);
        user.setPassword(password);
        
        if(user.getUserType().equals("Admin")) {
        	Admin admin = (Admin) user;
        } else if(user.getUserType().equals("Advertiser")) {
        	Advertiser advert = (Advertiser) user;
        } else if(user.getUserType().equals("Nutritionist")) {
        	Nutritionist nutrit = (Nutritionist) user;
        } else if(user.getUserType().equals("Vendor")) {
        	Vendor vendor = (Vendor) user;
        }
        
        u.userValidate(user);
    }
*/
    }
}
        
//        UserTable user=new UserTable();
//        
//
//        try {
//            if(new userservice().validUser(user)) {
//                HttpSession session=req.getSession();
//                session.setAttribute("user",user);
//                resp.sendRedirect("../main.jsp");
//            } else {
//                resp.sendRedirect("../index.jsp");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    	