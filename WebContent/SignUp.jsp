<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	<!-- Force Latest IE rendering engine -->
	<title>Sign Up</title>
	<meta name="description" content="">
	<meta name="author" content="">
	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" /> 
	
	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/skeleton.css">
	<link rel="stylesheet" href="css/layout.css">

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
	<!-- Primary Page Layout -->

	<div class="container">
		
		<div class="form-bg">
			<form action="userActionServlet" method="post">
				<h2>Sign Up</h2>
				<p><input type="text" placeholder="Username" name="uname"></p>
				<p><input type="password" placeholder="Password" name="pwd"></p>
			
				  <select name="type" size="1">
					<option value="admin">Administator</option>
			        <option value="advertiser">Advertiser</option>
			        <option value="nutritionist">Nutritionist</option>
			        <option value="vendor">Vendor</option>
    			 </select>
			
				 <input type ="hidden" name ="action" value="signup">
				 <button type="submit">Sign Up</button>
			<form>
		</div>

	</div><!-- container -->

	<!-- JS  -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
	<script>window.jQuery || document.write("<script src='js/jquery-1.5.1.min.js'>\x3C/script>")</script>
	<script src="js/app.js"></script>
	
<!-- End Document -->
</body>
</html>