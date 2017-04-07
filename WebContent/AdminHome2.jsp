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

	<h2>Display Area</h2>

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
	
		
	<table border="1"> <% 
	
		String usertype = (String) session.getAttribute("usertype");
		FindIterable<Document> docs = (FindIterable<Document>) session.getAttribute("userlists");	
		MongoCursor<Document> mongoCursor = docs.iterator();  
		Document details = null;
		Set<String> keys;
		Iterator<String> itr;
		int loopCount = 0;
		
		while(mongoCursor.hasNext()) {  %>
			
		<tr> <%
		
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
                	<input type = "hidden" name = "sourcePage" value = "/AdminHome2.jsp"/>
                	<input type = "hidden" name = "usertype" value = "<%=usertype%>"/>
                	<input type = "hidden" name = "deleteId" value = "<%=details.get("_id")%>" />
                	<input type = "submit" value = "delete" />
            	</form>
            </td>
		</tr> <% 
		} 
	} %>
	
	</table>
	
	
	<h2>Search Bar</h2>
	
	<form name = "searchDocument" action = "userActionServlet" method = "post">
		<p>
		username: <input type = "text" name = "username" />
		usertype:
		<select name = "usertype" size = "1">
	        <option value = "advertiser">Advertiser</option>
	        <option value = "nutritionist">Nutritionist</option>
	        <option value = "vendor">Vendor</option>
    	</select>
    	element ID: <input type = "text" name = "elementid" />
    	</p>
    	<p>
    	<input type ="hidden" name ="action" value="searchUser" />
  		<input type="submit" value="Search" />
    	</p>
	</form>
	<table> <% 
		if(request.getAttribute("searchResultLists") != null) {
			FindIterable<Document> docs2 = (FindIterable<Document>) request.getAttribute("searchResultLists"); 
			MongoCursor<Document> mongoCursor2 = docs2.iterator(); 
			Document details2 = null; 
			Set<String> keys2;
			Iterator<String> itr2; 
		
			while(mongoCursor2.hasNext()) { %>
		
		<tr> <% 
				
				details2 = mongoCursor2.next();
	        	keys2 = details2.keySet();
	        	itr2 = keys2.iterator();
	        	itr2.next();  // drop the first key which is _id.
				
				while(itr2.hasNext()) { %>
	        	
			<td><%=details2.get(itr2.next())%></td><%
		        } %>
		</tr><%
			} 
		} %>

		
	</table>
	
	
	<h2>Update Bar</h2> 
	
	<form name = "updateSelection" action = "formActionServlet" method = "post">
		<p>
		<input  type = "hidden" name = "action" value = "displayFormsByUsertype"/>
		usertype: 
		<select name = "usertype" onchange = "this.form.submit()">
			
			<option disabled selected value> -- select an option -- </option>
	        <option value="advertiser">Advertiser</option>
	        <option value="nutritionist">Nutritionist</option>
	        <option value="vendor">Vendor</option>
    	
    	</select>
    	</p>
    </form> <%
    
	if(request.getAttribute("keySet") != null) {
		
    	Set<String> keySet = (Set<String>) request.getAttribute("keySet");
    	String usertype2 = (String) request.getAttribute("usertype");
    	Iterator<String> itr3 = keySet.iterator();
    	String iterator;
    	 
    	// Drop the first element, which is _id
    	if(itr3.hasNext()) {
    		itr3.next();
    	} %>
    	
    <h3>Update: <%=usertype2%> info</h3>
    	
    <form name = "updateDocument" action = "userActionServlet" method = "post"><%
    	
    	while(itr3.hasNext()) { 
    	
    		iterator = itr3.next();%>
    		<%=iterator%>: <input type = "text" name = "ud_<%=iterator%>"> <% 
    		
    	} %>
    	<p>
    	<input type = "hidden" name = "usertype" value = "<%=usertype2%>"/>
    	<input type = "hidden" name = "sourcePage" value = "/AdminHome2.jsp">
    	<input type = "hidden" name = "action" value = "updateUsers"/>
    	<input type = "submit" value = "Update" />
    	</p>
    </form> <%
    } %>
    
	
</body>

</html>