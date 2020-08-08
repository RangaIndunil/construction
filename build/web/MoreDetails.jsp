<%-- 
    Document   : MoreDetails
    Created on : Oct 20, 2018, 11:35:53 PM
    Author     : Singer
--%>

<%@page import="Services.GetAccountDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About you Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="MoreDetails.css">
    <body>
        
        <%
            String[] DeveloperArry = new String[10];
            DeveloperArry[0] = "Masson";
            DeveloperArry[1] = "Tile";
            DeveloperArry[2] = "Carpentor";
            DeveloperArry[3] = "Plumber";
            DeveloperArry[4] = "Electrician";
            DeveloperArry[5] = "Painter";
            DeveloperArry[6] = "ConcreteSlab";
            DeveloperArry[7] = "Ceiling";
            DeveloperArry[8] = "Welding";
            DeveloperArry[9] = "Aluminium";
            
            String[] HardwareOwnerArry = new String[2];
            HardwareOwnerArry[0] = "Hardware Name";
            HardwareOwnerArry[1] = "Location";
            
            String[] TransporterArry = new String[3];
            TransporterArry[0] = "Vehicle Number";
            TransporterArry[1] = "Model";
            TransporterArry[2] = "Charge per 1Km";
            
            String UserName = (String) session.getAttribute("UName");
            String Type = (String) session.getAttribute("Type");
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>Please fill this form</b></p></center>
        </div>
        <div id="topicS"></div>
        
        
            <form action="SetMoreDetails" method="POST">
            
        <%
            if(Type.equals("developer") || Type.equals("Developer")){
                for(int i = 0; i < DeveloperArry.length; i++){
                    String temp1 = DeveloperArry[i] + " Work";
                    String temp2 = "Poto\\Developer\\" + DeveloperArry[i] + ".jpg";
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <table align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b><%=temp1%></b></td>
                            <td><img src="<%=temp2%>" width="75" height="50"/></td>
                            <td><input type="checkbox" name="<%=DeveloperArry[i]%>" value="true" /></td>
                        </tr>
                    </tbody>
            </table>
        </div>
        <div id="Side1"></div>
        
        <%
                }
            }
        %>
        
        <%
            if(Type.equals("hardwareowner") || Type.equals("Hardwareowner")){
                for(int i = 0; i < HardwareOwnerArry.length; i++){
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <table align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b><%=HardwareOwnerArry[i]%></b></td>
                            <td>
                                <input class="Text" type="text" 
                                       name="<%=HardwareOwnerArry[i]%>" value="" />
                            </td>
                        </tr>
                    </tbody>
            </table>
        </div>
        <div id="Side1"></div>
        
        <%
                }
            }
        %>
        
        <%
            if(Type.equals("transpoter") || Type.equals("Transpoter")){
                for(int i = 0; i < TransporterArry.length; i++){
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <table align="center" border="0">
                    <tbody>
                        <tr>
                            <td><b><%=TransporterArry[i]%></b></td>
                            <td>
                                <input class="Text" type="text" 
                                       name="<%=TransporterArry[i]%>" value="" />
                            </td>
                        </tr>
                    </tbody>
            </table>
        </div>
        <div id="Side1"></div>
        
        <%
                }
            }
        %>

        <div id="Side1"></div>
        <div id="Div1">
            <center>
                <td>
                    <input class="Button" type="submit" value="Submit" />
                </td>
            </center>
        </div>
        <div id="Side1"></div>
            </form>
        
    </body>
</html>
