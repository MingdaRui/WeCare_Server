package com.wecare.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.wecare.contoller.*;

/**
 * Servlet implementation class formActionServlet
 */
@WebServlet(name = "formActionServlet", urlPatterns = {"/formActionServlet"})
public class formActionServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String forwardToJsp = "";
        
        System.out.println("formActionServlet.java - request.getParameter(\"type\"): " + request.getParameter("type") 
    	+ "\nFor validating the type passed from \"AdminHome.jsp\"\n");
        
        if(request.getParameter("action") != null) {
           
            CommandFactory factory = new CommandFactory();
            Command command = factory.createCommand(request.getParameter("action"));
            forwardToJsp = command.execute(request, response);
            
//            System.out.println("formActionServlet.java - request.getParameter(\"usertype\"): " + request.getParameter("usertype"));
            
        }
        //System.out.println(forwardToJsp);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardToJsp);
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
