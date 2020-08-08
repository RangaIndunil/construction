<%-- 
    Document   : LogOut
    Created on : Oct 25, 2018, 2:58:55 PM
    Author     : Singer
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogOut Page</title>
    </head>
    <body>
        <%
            boolean value = true;
            
            Enumeration enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
		String key = enumeration.nextElement().toString();
		if(key.equals("UserName")){
                    value = false;
                    session.removeAttribute("UserName");
                    RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Home.jsp");
                    requestDispatcher.include(request, response);
                }
            }
            if(value){
                RequestDispatcher requestDispatcher = 
                        request.getRequestDispatcher("/LoginPage.jsp");
                requestDispatcher.include(request, response);
            }
        %>
    </body>
</html>
