<%-- 
    Document   : ViewProfile
    Created on : Oct 20, 2018, 6:24:09 PM
    Author     : Singer
--%>

<%@page import="Services.GetMobile"%>
<%@page import="Services.GetType"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Services.SetDashboarddata"%>
<%@page import="Services.GetTranspoterDetails"%>
<%@page import="Services.GetHardwareOwnerDetails"%>
<%@page import="Services.GetDeveloperDetails"%>
<%@page import="Services.GetAccountDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Details</title>
    </head>
    <link rel="stylesheet" type="text/css" href="ViewProfile.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <%
            String UserName = (String) session.getAttribute("UName");
            String SUserName = (String) session.getAttribute("SUserName");
            
            GetAccountDetails gad = new GetAccountDetails();
            SetDashboarddata sdd = new SetDashboarddata();
            GetType gt = new GetType();
            gad.SetDetails(SUserName);
            gt.SetDetails(SUserName);
            
            
            String SName = gad.getName();
            String url = "Poto\\" + sdd.getData(SUserName).toString();
            String Address = gad.getAddress();
            GetMobile gm = new GetMobile();
            gm.SetDetails(SUserName);
            gm.getNumbers();
            String[] Numbers = gm.getNumbers();
            String Email = gad.getEmail();
            String Type = gt.getType();
            
            String Mason = "Poto\\Developer\\Masson.jpg";
            String Tile = "Poto\\Developer\\Tile.jpg";
            String Carpentor = "Poto\\Developer\\Carpentor.jpg";
            String Plumber = "Poto\\Developer\\Plumber.jpg";
            String Electrician = "Poto\\Developer\\Electrician.jpg";
            String Painter = "Poto\\Developer\\Painter.jpg";
            String ConcreteSlab = "Poto\\Developer\\ConcreteSlab.jpg";
            String Ceiling = "Poto\\Developer\\Ceiling.jpg";
            String Welding = "Poto\\Developer\\Welding.jpg";
            String Aluminium = "Poto\\Developer\\Aluminium.jpg";
        %>
        
        <div id="Side1"></div>
        <div id="Div1">
            <br>
            <center><img src="<%=url%>" width="230" height="300"/></center>
            <center><p>
                <h3><%=SName%></h3>
            </p></center>
        </div>
        <div id="Side1"></div>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>Basic information</b></p></center>
        </div>
        <div id="topicS"></div>
        
        <div id="Side2"></div>
        <div id="Div2">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <th><b>Address :</b></th>
                        <th><b><%=Address%></b></th>
                    </tr>
                    <tr>
                        <td><b>Email :</b></td>
                        <td><b><%=Email%></b></td>
                    </tr>
                    <tr>
                        <td><b>Mobile</b></td>
                        <td><b>
                                <%
                                    for(int i =0; i<10; i++){
                                        try{
                                        if(Numbers[i].equals("No")){
                                            break;
                                        }
                                        }catch(NullPointerException e){
                                            break;
                                        }
                                %>
                                <%=Numbers[i]+"<br>"%>
                                <%
                                    }
                                %>
                        </b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side2"></div>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>About</b></p></center>
        </div>
        <div id="topicS"></div>
            
        <%
            if(Type.equals("Developer")){
                GetDeveloperDetails gdd = new GetDeveloperDetails();
                gdd.SetDetails(SUserName);
        %>
        
                    <%
                if(gdd.isMason()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Mason</b></td>
                        <td><img src="<%=Mason%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isTile()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Tile Work</b></td>
                        <td><img src="<%=Tile%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isCarpentor()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Carpenter Work</b></td>
                        <td><img src="<%=Carpentor%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isPlumber()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Plumber Work</b></td>
                        <td><img src="<%=Plumber%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isElectrician()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Electrician Work</b></td>
                        <td><img src="<%=Electrician%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isPainter()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Painter Work</b></td>
                        <td><img src="<%=Painter%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isConcreteSlab()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Concrete Slab Work</b></td>
                        <td><img src="<%=ConcreteSlab%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isAluminium()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Aluminium Work</b></td>
                        <td><img src="<%=Aluminium%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isWelding()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Welding Work</b></td>
                        <td><img src="<%=Welding%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
                if(gdd.isCeiling()){
        %>
        
        <div id="Side3"></div>
        <div id="Div3">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Ceiling Work</b></td>
                        <td><img src="<%=Ceiling%>" width="75" height="50"/></td>
                    </tr>
                    </tbody>
            </table>
        </div>
        <div id="Side3"></div>
        
        <%
                }
            }else if(Type.equals("Hardwareowner")){
                GetHardwareOwnerDetails ghd = new GetHardwareOwnerDetails();
                ghd.SetDetails(SUserName);
                String HardwareName = ghd.getHardwareName();
                String HardwareAddress = ghd.getHardwareAddress();
        %>
        
        <div id="Side4"></div>
        <div id="Div4">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Hardware Name :</b></td>
                        <td><b><%=HardwareName%></b></td>
                    </tr>
                    <tr>
                        <td><b>Hardware Address :</b></td>
                        <td><b><%=HardwareAddress%></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side4"></div>
        
        <%
            }else if(Type.equals("Transpoter")){
                GetTranspoterDetails gtd = new GetTranspoterDetails();
                gtd.SetDetails(SUserName);
                String VehicleNumber = gtd.getVehicleNumber();
                String Model = gtd.getModel();
                String Charge = gtd.getCharge();
        %>
        
        <div id="Side5"></div>
        <div id="Div5">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Vehicle Number :</b></td>
                        <td><b><%=VehicleNumber%></b></td>
                    </tr>
                    <tr>
                        <td><b>Model :</b></td>
                        <td><b><%=Model%></b></td>
                    </tr>
                    <tr>
                        <td><b>Charge per 1Km :</b></td>
                        <td><b><%=Charge%></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side5"></div>
        
        <%
            }
        %>
            
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>Feedbacks</b></p></center>
        </div>
        <div id="topicS"></div>
        
        <%    
            if(Type.equals("Developer")){
            String temp1 ="";
            String temp2 = "";
            
            Connection con;
            Statement st;
            String path = "jdbc:mysql://localhost:3306/constructiondb";
        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(path,"root","");
            st =  con.createStatement();
                    
            PreparedStatement pst;
            pst = con.prepareStatement("SELECT userdetails.FirstName, "
                    + "userdetails.LastName, feedbackfordeveloper.FeedBack FROM "
                    + "userdetails INNER JOIN feedbackfordeveloper ON "
                    + "feedbackfordeveloper.CName = userdetails.UserName "
                    + "WHERE feedbackfordeveloper.FName=?");
            pst.setString(1, SUserName);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                temp1 = rs.getString(1) + " " + rs.getString(2);
                temp2 = rs.getString(3);
        %>
        <div id="Side6"></div>
        <div id="Div6">
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><%=temp1%> :</td>
                        <td><%=temp2%></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side6"></div>
        
        <%
            }
            }
        %>
        
    </body>
</html>
