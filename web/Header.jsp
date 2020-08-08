<%-- 
    Document   : header
    Created on : Oct 23, 2018, 9:07:43 PM
    Author     : shehan
--%>

<%@page import="Services.GetAccountDetails"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <link rel="stylesheet" type="text/css" href="Header.css">
    </head>
    <body>
        
        <%
            String Dashboardurl = "LoginPage.jsp";
            Enumeration enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
		String key = enumeration.nextElement().toString();
		if(key.equals("UserName")){
                    String UserName = (String) session.getAttribute("UserName");
                    GetAccountDetails gad = new GetAccountDetails();
                    gad.SetDetails(UserName);
                    String Type = gad.getType();
                    
                    if(Type.equals("Customer")){
                        Dashboardurl = "Dashboard.jsp";
                    }else if(Type.equals("Developer")){
                        Dashboardurl = "Developer.jsp";
                    }else if(Type.equals("HardwareOwner")){
                        Dashboardurl = "HardwareOwner.jsp";
                    }else if(Type.equals("Transpoter")){
                        Dashboardurl = "Transpoter.jsp";
                    }
                    break;
                }
            }
        %>
        
        <div class="header">
            <table style="width: 100%; height: 20%; font-size: 20px">
                <tr>
                    <td><img src="CSS/Super-Construction.jpg" width="250px" height="90px"></td>
                    <td><h1 style="color: red;">Super Construction</h1></td>
                    <td><a href="LogOut.jsp">Logout</a></td>
                </tr>
            </table>
            <table style="width: 100%; height: 20%; font-size: 20px;">
                <tr>
                    <th><a href="Home.jsp">Home</a></th>
                    <th><a href="LoginPage.jsp">Login</a></th>
                    <th><a href="CreateAccount.jsp">Register</a></th>
                    <th><a href="<%=Dashboardurl%>">Dashboard</a></th>
                </tr>
            </table>
	</div>
    </body>
</html>
