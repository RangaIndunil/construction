<%-- 
    Document   : SearchTypes
    Created on : Oct 20, 2018, 11:49:41 AM
    Author     : Singer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <link rel="stylesheet" type="text/css" href="SearchType.css">
    <body>
        
        <%@include file="Dashboard.jsp" %>
        
        <%
            String Type = (String) session.getAttribute("Type");
            String Location = (String) session.getAttribute("Location");
            
            String tempFieldName = "";
            String temp1 ="";
            String temp2 = "";
            String temp3 ="";
            
            if(Type.equals("developer")){
                tempFieldName = "DName";
            }else if(Type.equals("hardwareowner")){
                tempFieldName = "HName";
            }else if(Type.equals("transpoter")){
                tempFieldName = "TName";
            }
            
            Connection con;
            Statement st;
            String path = "jdbc:mysql://localhost:3306/constructiondb";
        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(path,"root","");
            st =  con.createStatement();
                    
            PreparedStatement pst;
            pst = con.prepareStatement("SELECT FirstName, "
                    + "LastName, UserName, Photo FROM userdetails "
                    + "WHERE (Address LIKE '%"+ Location +"%' AND (UserName) IN "
                    + "(SELECT "+ tempFieldName +" FROM "+ Type +"))");
            
            //pst.setString(1, tempFieldName);
            //pst.setString(2, Type);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                temp1 = rs.getString(1) + " " + rs.getString(2);
                temp2 = rs.getString(3);
                temp3 = "Poto\\" + rs.getString(4);
        %>
        <div id="SideS"></div>
        <div class="DivS">
            <br>
            <br>
            <br>
            <form action="OnebyOne" method="POST">
                <input type="hidden" name="SUserName" value="<%=temp2%>">
                <table align="center">
                    <tr>
                        <td><b><%=temp1%></b></td>
                    </tr>
                    <tr>
                        <td><b><img src="<%=temp3%>" width="110" height="150"/></b></td>
                    </tr>
                </table>
                    <center><input class="Button" type="submit" value="More" /></center>
            </form>
            <%
                if(Type.equals("developer")){
            %>
            <form action="SetFeedback" method="POST">
                <input type="hidden" name="FUserName" value="<%=temp2%>">
                <table align="center">
                    <tr>
                        <td><textarea name="FeedBack" rows="3" cols="20"></textarea><td>
                    </tr>
                    <tr>
                    <td></td>
                    </tr>
                </table>
                <center><input class="Button" type="submit" value="Send Feedback" /></center>
            </form>
            <%
                }
            %>
        </div>
        <div id="SideS"></div>
        <%
            }
        %>
    </body>
</html>
