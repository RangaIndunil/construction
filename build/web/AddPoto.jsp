<%-- 
    Document   : AddPoto
    Created on : Sep 11, 2018, 10:38:33 PM
    Author     : Singer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Photo</title>
    </head>
    <link rel="stylesheet" type="text/css" href="AddPoto.css">
    <body>
        
        <%  
            String UserName = (String)session.getAttribute("UName");
            String Type = (String)session.getAttribute("Type");
        %>
        
        <div id="Top"></div>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><h3>Please upload your photo <%=UserName%></h3></center>
        </div>
        <div id="topicS"></div>
        
        <div id="Side"></div>
        <div id="Div">
            <form action="UserPoto" method="POST" enctype="multipart/form-data">
                <table class="table" align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b>Upload Image</b></td>
                            <td><input class="Button" type="file" name="photo" size="50" /></td>
                        </tr>
                        <tr>
                            <td><input class="Button" type="reset" value="Cancel" /></td>
                            <td><input class="Button" type="submit" value="Upload" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div id="Side"></div>
        
    </body>
</html>
