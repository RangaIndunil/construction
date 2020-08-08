<%-- 
    Document   : Developer
    Created on : Oct 20, 2018, 11:32:12 PM
    Author     : Singer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Services.GetDeveloperDetails"%>
<%@page import="Services.GetAccountDetails"%>
<%@page import="Services.SetDashboarddata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Developer Dashboard</title>
    </head>
    <link rel="stylesheet" type="text/css" href="Developer.css">
    <body>
        
        <%@include file="Header.jsp" %>
        
        <%
            String UserName = (String) session.getAttribute("UName");
            String Message = (String) session.getAttribute("Message");
            session.setAttribute("UMessage", "No");
            
            SetDashboarddata sd = new SetDashboarddata();
            GetAccountDetails gad = new GetAccountDetails();
            GetDeveloperDetails gdd = new GetDeveloperDetails();
            
            String url = "Poto\\" + sd.getData(UserName).toString();
            gad.SetDetails(UserName);
            gdd.SetDetails(UserName);
            String Name = gad.getName();
            String Address = gad.getAddress();
            //String City = gad.getCity();
            String Email = gad.getEmail();
            String Mobile = gad.getMobile();
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
            <center><p><b>Your basic Details</b></p></center>
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Address :</b></td>
                        <td><b><%=Address%></b></td>
                    </tr>
                    <tr>
                        <td><b>Email :</b></td>
                        <td><b><%=Email%></b></td>
                    </tr>
                    <tr>
                        <td><b>Mobile :</b></td>
                        <td><b><%=Mobile%></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="Side2"></div>
        
        <div id="topicS"></div>
        <div id="topicD"><center><p><b>Your work details</b></p></center></div>
        <div id="topicS"></div>
        
        <%
            if(gdd.isMason()){
        %>
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Mason Work</b></td>
                        <td><img src="<%=Mason%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isTile()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Tile Work</b></td>
                        <td><img src="<%=Tile%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isCarpentor()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Carpenter Work</b></td>
                        <td><img src="<%=Carpentor%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isPlumber()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Plumber Work</b></td>
                        <td><img src="<%=Plumber%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isElectrician()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Electrician Work</b></td>
                        <td><img src="<%=Electrician%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isPainter()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Painter Work</b></td>
                        <td><img src="<%=Painter%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isConcreteSlab()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Concrete Slab Work</b></td>
                        <td><img src="<%=ConcreteSlab%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isAluminium()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Aluminium Work</b></td>
                        <td><img src="<%=Aluminium%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isWelding()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Welding Work</b></td>
                        <td><img src="<%=Welding%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
            if(gdd.isCeiling()){
        %>
        
        <div id="SideD"></div>
        <div id="DivD">    
            <table class="table" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b>Ceiling Work</b></td>
                        <td><img src="<%=Ceiling%>" width="75" height="50"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideD"></div>
        
        <%
            }
        %>
        
        <div id="topicS"></div>
        <div id="topicD">
            <center><p><b>Feedbacks</b></p></center>
        </div>
        <div id="topicS"></div>
        
        <%    
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
            pst.setString(1, UserName);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                temp1 = rs.getString(1) + " " + rs.getString(2);
                temp2 = rs.getString(3);
        %>
        
        <div id="SideF"></div>
        <div id="DivF">
            <table class="tableF" align="center" border="0">
                <tbody>
                    <tr>
                        <td><b><%=temp1%> :</b></td>
                        <td><b><%=temp2%></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="SideF"></div>
        
        <%
            }
        %> 
    </body>
</html>
