<%@page import="com.mongodb.client.result.DeleteResult"%>
<%@page import="com.wecare.model.userservice.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
	       
                String items = request.getParameter("delitems"); 
                UserService hservice = new UserService();
                String[] item = items.split(","); 

                DeleteResult deleted = null;
                
                for (int i = 0; i < item.length; i++) { 
                    deleted = hservice.deleteByObjId((String)session.getAttribute("usertype"), item[i]);
                } 
        %>
    </body>
</html>
