
package com.wecare.contoller;

import javax.servlet.http.*;

import org.bson.Document;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.wecare.model.user.*;
import com.wecare.model.userservice.*;

public class RegisterCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String type = request.getParameter("type");
        
        String forwardToJsp = "";
        Document document = null;   
      
        switch (type) {
		case "admin":
			AdminService service = new AdminService();
			document = service.insert(new Admin(uname, pwd));
			break;
		case "advertiser":
			AdvertiserService service2 = new AdvertiserService();
//			document = service2.insert(new Admin(uname, pwd));
			document = service2.insert(new Advertiser(uname, pwd));
			break;
		case "nutritionist":
			NutritionistService service3 = new NutritionistService();
//			document = service3.insert(new Admin(uname, pwd));
			document = service3.insert(new Nutritionist(uname, pwd));
			break;
		case "vendor":
			VendorService service4 = new VendorService();
//			document = service4.insert(new Admin(uname, pwd));
			document = service4.insert(new Vendor(uname, pwd));
			break;
		default:
			break;
		} // end switch
        
        if(document != null) {
        	forwardToJsp = "/Login.jsp";
        }
        return forwardToJsp;
    
    }

}
