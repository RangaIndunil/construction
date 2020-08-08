<%-- 
    Document   : LoginPage
    Created on : Oct 24, 2018, 12:58:56 AM
    Author     : Singer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="Login.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <div class="Top"></div>
        <div id="Side"></div>
        <div class="Div">
            <form action="LoginControler" method="POST">
                <table class="table" align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b>Name :</b></td>
                            <td><input class="Text" type="text" name="UserName" value="" /></td>
                        </tr>
                        <tr>
                            <td><b>Password :</b></td>
                            <td><input class="Text" type="password" name="Password" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <center><input class="Button" type="submit" value="Login" /></center>
            </form>
        </div>
        <div id="Side"></div>
    </body>
</html>
