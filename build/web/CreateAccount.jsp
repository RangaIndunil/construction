<%-- 
    Document   : CreateAccount
    Created on : Oct 13, 2018, 1:10:53 PM
    Author     : Singer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        
        <script>
            function myFunction() {

                var Counter =  document.getElementById("Counter").value;
                var holding = document.getElementById("myclass").innerHTML;

                var newholding = holding + "<input class= 'Text' type = 'text' name = 'Mobile" + Counter + "' /> <br>";

                Counter++;

                document.getElementById("Counter").value = Counter;

                document.getElementById("myclass").innerHTML = newholding;
            }
        </script>
    </head>
    <link rel="stylesheet" type="text/css" href="CreateAccount.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <div class="Top"></div>
        <div id="Side"></div>
        <div class="Div">
            <form action="NewUser" method="POST">
                <input type="hidden" id="Counter" value="1" />
                
                <table class="table" align="center">
                    <tbody>
                        <tr>
                            <td><b>Create Account as a</b></td>
                            <td>
                            <input type="radio" name="type" value="coustomer" 
                                   required title=""/> <b>Customer</b><br>
                            <input type="radio" name="type" value="developer" 
                                   required title=""/> <b>Developer</b><br>
                            <input type="radio" name="type" value="hardwareowner" 
                                   required title=""/> <b>Hardware Owner</b><br>
                            <input type="radio" name="type" value="transpoter" 
                                   required title=""/> <b>Transporter</b>
                            </td>
                        </tr>
                        <tr>
                            <td><b>First Name</b></td>
                            <td><input class="Text" type="text" name="FName" value="" 
                                       required title="Ranga"/></td>
                        </tr>
                        <tr>
                            <td><b>Last Name</b></td>
                            <td><input class="Text" type="text" name="LName" value="" 
                                       required title="Indunil"/></td>
                        </tr>
                        <tr>
                            <td><b>User Name</b></td>
                            <td><input class="Text" type="text" name="UserName" value="" 
                                       required title="Ranga"/></td>
                        </tr>
                        <tr>
                            <td><b>BirthDay</b></td>
                            <td><input class="Text" type="text" name="BirthDay" value="YYYY/MM/DD" 
                                       required title="2001/01/01"/></td>
                        </tr>
                        <tr>
                            <td><b>Address</b></td>
                            <td>
                            <input class="Text" type="text" name="Address" value="" 
                                   required title="No 25/12, Colombo Road, Kotte"/>
                            </td>
                        </tr>
                        <tr>
                            <td><b>City</b></td>
                            <td><input class="Text" type="text" name="City" value="" 
                                       required title="Colombo"/></td>
                        </tr>
                        <tr>
                            <td><b>Email Address</b></td>
                            <td><input class="Text" type="text" name="Email" value="" 
                                       required title="-------@gmail.com"/></td>
                        </tr>
                        <tr>
                            <td><b>Mobile</b></td>
                            <td>
                                <div id="myclass">
                                    <input class= 'Text' type = 'text' name = 'Mobile0' value="" /> <br>
                                </div>
                                
                                <br>
                                
                                <button type="button" onclick="myFunction()">Add</button>
                            </td>
                        </tr>
                        <tr>
                            <td><b>Enter Password</b></td>
                            <td>
                            <input class="Text" type="password" name="EPassword" pattern=".{8,12}" 
                                   required title="8 to 12 characters">
                            </td>
                        </tr>
                        <tr>
                            <td><b>Conform Password</b></td>
                            <td>
                            <input class="Text" type="password" name="CPassword" pattern=".{8,12}" 
                                   required title="8 to 12 characters">
                            </td>
                        </tr>
                        
                        <tr>
                            <td><input class="Button" type="reset" value="Cancel" /></td>
                            <td><input class="Button" type="submit" value="Submit" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div id="Side"></div>
    </body>
</html>
