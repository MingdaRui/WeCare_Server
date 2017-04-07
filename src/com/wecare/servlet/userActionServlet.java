/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wecare.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.wecare.contoller.Command;
import com.wecare.contoller.CommandFactory;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "userActionServlet", urlPatterns = {"/userActionServlet"})
public class userActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String forwardToJsp = "";
        
        HttpSession session = request.getSession();
        
        CommandFactory factory;
        Command command = null;
        
//        System.out.println("userActionServlet.java - request.getParameter(\"type\"): " + request.getParameter("type") 
//    	+ "\nFor validating the type passed from \"AdminHome.jsp\"\n");
        
        
        System.out.println("userActionServlet.java - processRequest(): \n"
    			+ "request.getParameter(\"action\") = " + request.getParameter("action") + "\n"
    			+ "request.getAttribute(\"action\") = " + (String) request.getAttribute("action") + "\n");
    	String tryResult = (String) session.getAttribute("try");
    	String usertype = (String) session.getAttribute("usertype");
		Document userObj;
		
		userObj = (Document) session.getAttribute("userObj");
		
		System.out.println("userActionServlet.java - processRequest(): \n"
				+ "request.getAtrribute(\"try\"): " + tryResult + "\n"
				+ "request.getAttribute(\"usertype\"): " + usertype
//				+ "request.getAttribute(\"userObj\"): " + userObj.toJson() + "\n"
				);
    	if(userObj != null) {
    		System.out.println("request.getAttribute(\"userObj\"): " + userObj.toJson() + "\n");
    	} else {
    		System.out.println("request.getAttribute(\"userObj\") == null\n");
    	}
        
        
        factory = new CommandFactory();
        
        if(request.getAttribute("action") == null && request.getParameter("action") != null) {
        	
            System.out.println("userActionServlet.java - processRequest():\n"
            		+ "Goes into request.getAttribute(\"action\") == null && request.getParameter(\"action\") != null\n");
        	
        	command = factory.createCommand(request.getParameter("action"));
//            forwardToJsp = command.execute(request, response);
//
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardToJsp);
//            dispatcher.forward(request, response);
            
//          System.out.println("userActionServlet.java - request.getParameter(\"usertype\"): " + request.getParameter("usertype"));
            
        } else if(request.getAttribute("action") != null) {
        	
            System.out.println("userActionServlet.java - processRequest():\n"
            		+ "Goes into request.getAttribute(\"action\") != null\n"
            		+ "request.getAttribute(\"action\") == " + request.getAttribute("action") + "\n");
        	
        	command = factory.createCommand((String) request.getAttribute("action"));
        	
        }
        
        System.out.println("userActionServlet.java.100 - processRequest():\n"
        		+ "forwardToJsp: " + forwardToJsp + "\n"
        		+ "This is 1 times\n");
        
        forwardToJsp = command.execute(request, response);
        
        System.out.println("userActionServlet.java.100 - processRequest():\n"
        		+ "forwardToJsp: " + forwardToJsp + "\n"
        		+ "This is 2 times\n");
        
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardToJsp);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardToJsp);

        System.out.println("userActionServlet.java.100 - processRequest():\n"
        		+ "forwardToJsp: " + forwardToJsp + "\n"
        		+ "This is 3 times\n");
        
        dispatcher.forward(request, response);

        System.out.println("userActionServlet.java.100 - processRequest():\n"
        		+ "forwardToJsp: " + forwardToJsp + "\n"
        		+ "This is 4 times\n");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
