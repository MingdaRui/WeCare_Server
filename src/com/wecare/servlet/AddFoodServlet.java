package com.wecare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wecare.entry.Food;
import com.wecare.model.userservice.FoodService;

/**
 * Servlet implementation class AddFoodServlet
 */
@WebServlet("/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FoodService service = new FoodService();
		
		Food food = getFoodObj(request);
		
		response.setContentType("text/plain; charset=UTF-8");  
        PrintWriter out = response.getWriter(); 
        if(service.insert(food) != null){
        	out.print("1"); 
        }else{
        	out.print("0"); 
        }
        out.close();  
	}


	private Food getFoodObj(HttpServletRequest request) {
		String kind  = request.getParameter("kind");
		String c = request.getParameter("categray");
		String gStr = request.getParameter("g");
		String calorieStr = request.getParameter("calorie");
		String userid = request.getParameter("userId");

		
		Food food = null;
		
		if(kind != null && !kind.equals("") && c != null && !c.equals("") && !gStr.equals("") && gStr != null
				&& calorieStr != null && !calorieStr.equals("") && userid != null && !userid.equals("")){
			double g = Double.parseDouble(gStr);
			double calorie = Double.parseDouble(calorieStr);
			food = new Food(kind, c, g, calorie, userid);
		}
		
		return food;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
