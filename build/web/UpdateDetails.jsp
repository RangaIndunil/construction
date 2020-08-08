<%-- 
    Document   : UpdateDetails
    Created on : Oct 23, 2018, 1:35:52 AM
    Author     : Singer
--%>

<%@page import="Services.GetMobile"%>
<%@page import="Services.GetType"%>
<%@page import="Services.SetDashboarddata"%>
<%@page import="Services.GetAccountDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Details Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="UpdateDetails.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <%
            String UserName = (String) session.getAttribute("UName");
            GetAccountDetails gad = new GetAccountDetails();
            SetDashboarddata sd = new SetDashboarddata();
            GetType gt = new GetType();
            GetMobile gm = new GetMobile();
            String url = "Poto\\" + sd.getData(UserName).toString();
            gad.SetDetails(UserName);
            gt.SetDetails(UserName);
            gm.SetDetails(UserName);
            
            String Name = gad.getName();
            String FName = gad.getFName();
            String LName = gad.getLName();
            String BirthDay = gad.getBirthday();
            String Address = gad.getAddress();
            String Email = gad.getEmail();
            String Mobile[] = gm.getNumbers();
            String Password = gad.getPassword();
            String Type = gt.getType();
            
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
            HardwareOwnerArry[1] = "Hardware Address";
            
            String[] TransporterArry = new String[3];
            TransporterArry[0] = "Vehicle Number";
            TransporterArry[1] = "Model";
            TransporterArry[2] = "Charge per 1Km";
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <br>
            <center><img src="<%=url%>" width="230" height="300"/></center>
            <center><p>
                <h3><%=Name%></h3>
            </p></center>
        </div>
        <div id="Side1"></div>
            
        <%
            String UMessage = (String) session.getAttribute("UMessage");
            if(!UMessage.equals("No")){
                session.setAttribute("UMessage", "No");
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><h4><%=UMessage%></h4></center>
        </div>
        <div id="Side1"></div>
        
        <%
            }
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>
                        Update basic details
                    </b></p>
            </center>
        </div>
        <div id="topicS"></div>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>
                Please only fill details which you want to update
            </b></p>
            </center>
        </div>
        <div id="topicS"></div>
        
        <div id="Side2"></div>
        <div id="Div2">
            <form action="Update" method="POST">
                <table class="table" align="center" border="0">
                    <tbody>
                        <input type="hidden" name="Data" value="Basic">
                        <input type="hidden" name="Type" value="<%=Type%>">
                        <tr>
                            <td><b>First Name :</b></td>
                            <td>
                                <input class="Text" type="text" name="FName" 
                                       value="<%=FName%>" />
                            </td>
                        </tr>
                        <tr>
                            <td><b>Last Name :</b></td>
                            <td>
                                <input class="Text" type="text" name="LName" 
                                       value="<%=LName%>" />
                            </td>
                        </tr>
                        <tr>
                            <td><b>BirthDay :</b></td>
                            <td>
                                <input class="Text" type="text" name="BirthDay" 
                                       value="<%=BirthDay%>" />
                            </td>
                        </tr>
                        <tr>
                            <td><b>Address :</b></td>
                            <td>
                                <input class="Text" type="text" name="Address" 
                                       value="<%=Address%>" />
                            </td>
                        </tr>
                        <tr>
                            <td><b>Email :</b></td>
                            <td>
                                <input class="Text" type="text" name="Email" 
                                       value="<%=Email%>" />
                            </td>
                        </tr>
                        <tr>
                            <center><td>
                                <input class="Button" type="submit" value="Update" />
                            </td></center>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div id="Side2"></div>
        
        
        <form action="Update" method="POST">
        <%
            if(!Type.equals("Customer") || !Type.equals("customer")){
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p>
                Update work details
            </p></center>
        </div>
        <div id="topicS"></div>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p>
            Please only fill details which you want to update
        </p></center>
        </div>
        <div id="topicS"></div>
        
        <%
            }
        %>
                
            <input type="hidden" name="Data" value="Work">
            <input type="hidden" name="Type" value="<%=Type%>">
            
        <%
            if(Type.equals("Developer") || Type.equals("developer")){
                for(int i = 0; i < DeveloperArry.length; i++){
                    String temp1 = DeveloperArry[i] + " Work";
                    String temp2 = "Poto\\Developer\\" + DeveloperArry[i] + ".jpg";
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><%=temp1%></td>
                        <td><img src="<%=temp2%>" width="75" height="50"/></td>
                        <td><input type="checkbox" name="<%=DeveloperArry[i]%>" value="true" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
            }
        %>
        
        <%
            if(Type.equals("Hardwareowner") || Type.equals("hardwareowner")){
                for(int i = 0; i < HardwareOwnerArry.length; i++){
        %>
        
        <div id="Side4"></div>
        <div id="Div4">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><%=HardwareOwnerArry[i]%></td>
                        <td><input type="text" name="<%=HardwareOwnerArry[i]%>" value="" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side4"></div>
        
        <%
                }
            }
        %>
        
        <%
            if(Type.equals("Transpoter") || Type.equals("transpoter")){
                for(int i = 0; i < TransporterArry.length; i++){
        %>
        
        <div id="Side4"></div>
        <div id="Div4">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><%=TransporterArry[i]%></td>
                        <td><input type="text" name="<%=TransporterArry[i]%>" value="" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side4"></div>
        
        <%
                }
            }
            if(!Type.equals("Customer") || !Type.equals("customer")){
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center>
                <input class="Button" type="submit" value="Update" />
            </center>
        </div>
        <div id="topicS"></div>
        
        <%
            }
        %>
        
    </body>
</html>
