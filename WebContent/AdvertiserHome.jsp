<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.bson.Document"%>
<%@page import="com.mongodb.client.FindIterable"%>
<%@page import="com.mongodb.client.MongoCursor"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Advertiser Home</title>
</head>
<body>

<h1>This is the AdvertierHome.jsp</h1>

<h2>My Ad List</h2>


	<table border="1">
		<%String usertype = (String) session.getAttribute("usertype"); %>
		<%Document details = null; %>
		<%Set<String> keys; %>
		<%Iterator<String> itr; %>
		<%int loopCount = 0; %>
		<%FindIterable<Document> findByUsername = (FindIterable<Document>) session.getAttribute("findByUsername"); %>
		<%if(findByUsername != null) {%>
			<%MongoCursor<Document> mongoCursor = findByUsername.iterator(); %>
			<%while(mongoCursor.hasNext()) { %>
		<tr>
				<%details = mongoCursor.next(); %>
				<%keys = details.keySet(); %>
				<%itr = keys.iterator(); %>
				<%itr.next(); // drop the first key which is _id. %>
		
				<%if(++loopCount == 1) { %>
					<%while(itr.hasNext()) {%>
					<th><%=itr.next() %></th>
					<%} %>
					<%mongoCursor = findByUsername.iterator(); // Move cursor to the begining %>
		</tr>	
				<%} else {%>	
					<%while(itr.hasNext()) { %>
					<td><%=details.get(itr.next()) %></td>
					<%} %>
				<td>
		    		<form class = "form1"  name = "deleteUser"  action = "userActionServlet" method = "post">
                		<input type = "hidden" name = "action" value = "deleteUser"/>
                		<input type = "hidden" name = "sourcePage" value = "/AdvertiserHome.jsp"/>
                		<input type = "hidden" name = "usertype" value = "<%=usertype%>"/>
                		<input type = "hidden" name = "deleteId" value = "<%=details.get("_id")%>" />
                		<input type = "submit" value = "delete" />
            		</form>
            	</td>
		</tr>
				<%} %>
			<%} %>
		<%} else {System.out.println("AdvertiserHome.jsp: findByUsername == null");} %>
	</table>


<h2>Update Bar</h2>
	
	<form name = "updateAd" action = "userActionServlet" method = "post">
		<p>ad_id: <input type = "text" name = "ud_ad_id"></p>
		<p>ad_title: <input type = "text" name = "ud_ad_title" ></p>
		<p>ad_description: <input type = "text" name = "ud_ad_description"></p>
		<input type = "hidden" name = "ud_username" value = <%=details.get("username") %>>
		<input type = "hidden" name = "ud_password" value = <%=details.get("password") %>>
		<%System.out.println("AdvertiserHome.jsp - username: " + details.get("username")); %>
		<input type = "hidden" name = "usertype" value = "advertiser">
		<input type = "hidden" name = "sourcePage" value = "/AdvertiserHome.jsp">
		<input type = "hidden" name = "action" value = "updateUsers">
		<input type = "submit" value = "update">
	</form>
	
</body>
</html>













