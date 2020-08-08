<%-- 
    Document   : HardwareOwner
    Created on : Oct 21, 2018, 12:35:19 PM
    Author     : Singer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Services.GetHardwareOwnerDetails"%>
<%@page import="Services.GetAccountDetails"%>
<%@page import="Services.SetDashboarddata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hardware Owner Dashboard</title>
    </head>
    <link rel="stylesheet" type="text/css" href="HardwareOwner.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <%
            String UserName = (String) session.getAttribute("UName");
            session.setAttribute("UMessage", "No");
            
            SetDashboarddata sd = new SetDashboarddata();
            GetAccountDetails gad = new GetAccountDetails();
            GetHardwareOwnerDetails ghd = new GetHardwareOwnerDetails();
            
            String url = "Poto\\" + sd.getData(UserName).toString();
            ghd.SetDetails(UserName);
            gad.SetDetails(UserName);
            String Name = gad.getName();
            String HardwareName = ghd.getHardwareName();
            String HardwareAddress = ghd.getHardwareAddress();
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <br>
            <center><img src="<%=url%>" width="230" height="300"/></center>
            <center><p>
                <h3><%=Name%></h3>
            </p></center>
            <center><a href="UpdateDetails.jsp">Update Details</a></center>
        </div>
        <div id="Side1"></div>
        
        <%
            String UMessage = (String) session.getAttribute("UDMessage");
            if(!UMessage.equals("No")){
                session.setAttribute("UDMessage", "");
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <center><h4><%=UMessage%></h4></center>
        </div>
        <div id="Side3"></div>
        
        <%
            }
        %>
        
        <div id="Side2"></div>
        <div id="Div2">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Hardware Name :</b></td>
                        <td><b><%=HardwareName%></b></td>
                    </tr>
                    <tr>
                        <td><b>Hardware Address:</b></td>
                        <td><b><%=HardwareAddress%></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side2"></div>
                
    </body>
</html>
