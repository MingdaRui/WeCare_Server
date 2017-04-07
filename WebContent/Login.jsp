<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<script>  
          function showErroMsg(){
                
                var msg = "<%=session.getAttribute("erroMsg")%>";
          
                
                if(msg != "null"){ 
                   
                    alert(msg);
               
                   }
                
                <%session.removeAttribute("erroMsg");%> 
               
            }
            showErroMsg();
     </script>
       
</head>
<body>

  <h1>Login in Your Account</h1>
	<form action="userActionServlet" name="login" method="post">
    	<p>username<input type="text" name="username"></p>
    	<p>password<input type="text" name="password"></p>
    	<select name="usertype" size="1">
			<option value="admin">Administator</option>
	        <option value="advertiser">Advertiser</option>
	        <option value="nutritionist">Nutritionist</option>
	        <option value="vendor">Vendor</option>
    	</select>
    	<input type ="hidden" name ="action" value="login">
  		<input type="submit" value="Submit" />
	</form>
</body>
</html>