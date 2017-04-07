<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
</head>

<!--<body>
	<h1>Welcome to Admin Page</h1>
	<p><a href="userActionServlet?action=displayUsers&type=advertiser">Display Advertisors</a></p>
	<p><a href="userActionServlet?action=displayUsers&type=vendor">Display Vendors</a></p>
	<p><a href="userActionServlet?action=displayUsers&type=nutritionist">Display Nutritionist</a></p>
</body>-->



<body>
	<h1>Welcome to Admin Page</h1>

	<!--This is the button way-->
	<form action = "userActionServlet" method = "post">
		<input  type = "hidden" name = "action" value = "displayUsers"/>
		<button type = "submit" name = "type"  value = "advertiser">Advertisors</button>
		<button type = "submit" name = "type"  value = "vendor">Vendors</button>
		<button type = "submit" name = "type"  value = "nutritionist">Nutritionists</button>
	</form>

	<!--This is the INPUT way-->
	<!--<p><form action = "userActionServlet" method = "post">
		<input type = "hidden" name = "action" value = "displayUsers"/>
        <input type = "hidden" name = "type" value = "advertiser"/>
        <input type = "submit" value = "Advertisers" />
	</form></p>

	<p><form action = "userActionServlet" method = "post">
		<input type = "hidden" name = "action" value = "displayUsers"/>
        <input type = "hidden" name = "type" value = "vendor"/>
        <input type = "submit" value = "Vendors" />
	</form></p>

	<p><form action = "userActionServlet" method = "post">
		<input type = "hidden" name = "action" value = "displayUsers"/>
        <input type = "hidden" name = "type" value = "nutritionist"/>
        <input type = "submit" value = "Nutritionists" />
	</form></p>-->
	
	
	
	
	
</body>

</html>