<%-- 
    Document   : Dashboard
    Created on : Sep 14, 2018, 3:30:12 PM
    Author     : Singer
--%>

<%@page import="Services.GetAccountDetails"%>
<%@page import="Services.SetDashboarddata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="Dashboard.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <%
            String UserName = (String) session.getAttribute("UName");
            session.setAttribute("UMessage", "No");
            SetDashboarddata sd = new SetDashboarddata();
            GetAccountDetails gad = new GetAccountDetails();
            String url = "Poto\\" + sd.getData(UserName).toString();
            gad.SetDetails(UserName);
            String Name = gad.getName();
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
                session.setAttribute("UDMessage", "No");
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
            <form action="DashboardProcess" method="POST">
                <center><table class="table" align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b>Enter Location</b></td>
                            <td><input class="Text" type="text" name="Location" value="" /></td>
                        </tr>
                        <tr>
                            <td><b>Select Type</b></td>
                            <td>
                                <input type="radio" name="type" value="developer" checked="checked"/> 
                                <b>Developer</b><br>
                                <input type="radio" name="type" value="hardwareowner" /> 
                                <b>Hardware Owner</b><br>
                                <input type="radio" name="type" value="transpoter" /> 
                                <b>Transporter</b>
                            </td>
                        </tr>
                    </tbody>
                </table></center>
                <center>
                    <input class="Button" type="submit" value="Search" />
                </center>
            </form>
        </div>
        <div id="Side2"></div>
                    
        <%
            String FMessage = (String) session.getAttribute("FMessage");
            session.setAttribute("FMessage", "");
            if(!FMessage.equals("")){
        %>
        <div id="Side3"></div>
        <div id="Div3">
            <center><p><b><%=FMessage%></b></p></center>
        </div>
        <div id="Side3"></div>
        <%
            }
        %>
    </body>
</html>
