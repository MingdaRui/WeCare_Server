package com.wecare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.wecare.entry.Food;
import com.wecare.model.userservice.FoodService;

/**
 * Servlet implementation class ListRecommendServlet
 */
@WebServlet(name = "ListRecommendServlet", urlPatterns = {"/ListRecommendServlet"})
public class ListRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FoodService cService = new FoodService();
		String kind = request.getParameter("kind");
		String catagray = request.getParameter("catagray");
		double gram = Double.parseDouble(request.getParameter("g"));
		double calorie = Double.parseDouble(request.getParameter("calorie"));
		String userId = request.getParameter("userId");
		
		Food food = new Food(kind, catagray, gram, calorie, userId);
		
		Food re = cService.listAllFood(food);
		response.setContentType("text/plain; charset=UTF-8");  
        PrintWriter out = response.getWriter(); 
        
        if(re != null){
        	JSONObject jsonObject = new JSONObject(re);
        	String myJson  =jsonObject.toString();
        	out.print(myJson); 
        }else{
        	out.print("no recommendation"); 
        }
        out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
