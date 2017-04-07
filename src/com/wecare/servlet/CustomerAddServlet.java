package com.wecare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;
import com.wecare.model.user.Customer;
import com.wecare.model.userservice.CustomerService;
import com.wecare.util.DateUtil;

/**
 * Servlet implementation class CustomerAddServlet
 */
@WebServlet(name = "CustomerAddServlet", urlPatterns = {"/CustomerAddServlet"})
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService cService = new CustomerService();
		Date dayOfBirth = DateUtil.getConvertStringToDate(request.getParameter("dob"));

		Customer customer = new Customer(request.getParameter("username"), request.getParameter("password"), 
				request.getParameter("email"), request.getParameter("userGoal"), request.getParameter("gender"), 
				dayOfBirth, request.getParameter("country"), Double.parseDouble(request.getParameter("height")), 
				Double.parseDouble(request.getParameter("weight")), Double.parseDouble(request.getParameter("goalOfWeight")), 
				Double.parseDouble(request.getParameter("weeklyGoal")));
		
		response.setContentType("text/plain; charset=UTF-8");  
        PrintWriter out = response.getWriter(); 
        if(cService.insert(customer) != null){
        	out.print(cService.getCustomerIdByUsername(request.getParameter("username"))); 
        }else{
        	out.print("1"); 
        }
        out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
