<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.bson.Document"%>
<%@page import="com.mongodb.client.FindIterable"%>
<%@page import="java.util.*"%>
<%@page import="com.mongodb.client.MongoCursor"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display User Lists</title>
</head>
<body>
	
	<table border="1">

		<tr> <% 
			String usertype = (String) session.getAttribute("usertype");
			FindIterable<Document> docs = (FindIterable<Document>) session.getAttribute("userlists");	
			MongoCursor<Document> mongoCursor = docs.iterator();  
			Document details = null;
			Set<String> keys;
			Iterator<String> itr;
			int loopCount = 0;
			
	        while(mongoCursor.hasNext()) { 
	        	details = mongoCursor.next();
	        	keys = details.keySet();
	        	itr = keys.iterator();
	        	itr.next();  // drop the first key which is _id.
	        	
	        	if(++loopCount == 1) {
	        		while(itr.hasNext()) { %>
	        <th><%=itr.next()%></th> <%
	        		} 
	        		mongoCursor = docs.iterator(); // Move cursor to the begining%>
		</tr> <%
	        	} else {
	        	while(itr.hasNext()) { %>
	        	
	        <td><%=details.get(itr.next())%></td><%
	        	
	        	} %>
	
		    <td>
		    	<form class = "form1"  name = "deleteUser"  action = "userActionServlet" method = "post">
                	<input type = "hidden" name = "action" value = "deleteUser"/>
                	<input type = "hidden" name = "usertype" value = "<%=usertype%>"/>
                	<input type = "hidden" name = "deleteId" value = "<%=details.get("_id")%>" />
                	<input type = "submit" value = "delete" />
            	</form>
            </td>
		</tr> <% 
	        } 
		} %>
	
	</table>
			
</body>
</html>