package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Services.GetAccountDetails;
import java.util.Enumeration;

public final class CreateAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create Account</title>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("\n");
      out.write("                var Counter =  document.getElementById(\"Counter\").value;\n");
      out.write("                var holding = document.getElementById(\"myclass\").innerHTML;\n");
      out.write("\n");
      out.write("                var newholding = holding + \"<input class= 'Text' type = 'text' name = 'Mobile\" + Counter + \"' /> <br>\";\n");
      out.write("\n");
      out.write("                Counter++;\n");
      out.write("\n");
      out.write("                document.getElementById(\"Counter\").value = Counter;\n");
      out.write("\n");
      out.write("                document.getElementById(\"myclass\").innerHTML = newholding;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"CreateAccount.css\">\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Header Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Header.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            String Dashboardurl = "LoginPage.jsp";
            Enumeration enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
		String key = enumeration.nextElement().toString();
		if(key.equals("UserName")){
                    String UserName = (String) session.getAttribute("UserName");
                    GetAccountDetails gad = new GetAccountDetails();
                    gad.SetDetails(UserName);
                    String Type = gad.getType();
                    
                    if(Type.equals("Customer")){
                        Dashboardurl = "Dashboard.jsp";
                    }else if(Type.equals("Developer")){
                        Dashboardurl = "Developer.jsp";
                    }else if(Type.equals("HardwareOwner")){
                        Dashboardurl = "HardwareOwner.jsp";
                    }else if(Type.equals("Transpoter")){
                        Dashboardurl = "Transpoter.jsp";
                    }
                    break;
                }
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"header\">\n");
      out.write("            <table style=\"width: 100%; height: 20%; font-size: 20px\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"CSS/Super-Construction.jpg\" width=\"250px\" height=\"90px\"></td>\n");
      out.write("                    <td><h1 style=\"color: red;\">Super Construction</h1></td>\n");
      out.write("                    <td><a href=\"LogOut.jsp\">Logout</a></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <table style=\"width: 100%; height: 20%; font-size: 20px;\">\n");
      out.write("                <tr>\n");
      out.write("                    <th><a href=\"Home.jsp\">Home</a></th>\n");
      out.write("                    <th><a href=\"LoginPage.jsp\">Login</a></th>\n");
      out.write("                    <th><a href=\"CreateAccount.jsp\">Register</a></th>\n");
      out.write("                    <th><a href=\"");
      out.print(Dashboardurl);
      out.write("\">Dashboard</a></th>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("\t</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"Top\"></div>\n");
      out.write("        <div id=\"Side\"></div>\n");
      out.write("        <div class=\"Div\">\n");
      out.write("            <form action=\"NewUser\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" id=\"Counter\" value=\"1\" />\n");
      out.write("                \n");
      out.write("                <table class=\"table\" align=\"center\">\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Create Account as a</b></td>\n");
      out.write("                            <td>\n");
      out.write("                            <input type=\"radio\" name=\"type\" value=\"coustomer\" \n");
      out.write("                                   required title=\"\"/> <b>Customer</b><br>\n");
      out.write("                            <input type=\"radio\" name=\"type\" value=\"developer\" \n");
      out.write("                                   required title=\"\"/> <b>Developer</b><br>\n");
      out.write("                            <input type=\"radio\" name=\"type\" value=\"hardwareowner\" \n");
      out.write("                                   required title=\"\"/> <b>Hardware Owner</b><br>\n");
      out.write("                            <input type=\"radio\" name=\"type\" value=\"transpoter\" \n");
      out.write("                                   required title=\"\"/> <b>Transporter</b>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>First Name</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"FName\" value=\"\" \n");
      out.write("                                       required title=\"Ranga\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Last Name</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"LName\" value=\"\" \n");
      out.write("                                       required title=\"Indunil\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>User Name</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"UserName\" value=\"\" \n");
      out.write("                                       required title=\"Ranga\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>BirthDay</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"BirthDay\" value=\"YYYY/MM/DD\" \n");
      out.write("                                       required title=\"2001/01/01\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Address</b></td>\n");
      out.write("                            <td>\n");
      out.write("                            <input class=\"Text\" type=\"text\" name=\"Address\" value=\"\" \n");
      out.write("                                   required title=\"No 25/12, Colombo Road, Kotte\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>City</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"City\" value=\"\" \n");
      out.write("                                       required title=\"Colombo\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Email Address</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"Email\" value=\"\" \n");
      out.write("                                       required title=\"-------@gmail.com\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Mobile</b></td>\n");
      out.write("                            <td>\n");
      out.write("                                <div id=\"myclass\">\n");
      out.write("                                    <input class= 'Text' type = 'text' name = 'Mobile0' value=\"\" /> <br>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <br>\n");
      out.write("                                \n");
      out.write("                                <button type=\"button\" onclick=\"myFunction()\">Add</button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Enter Password</b></td>\n");
      out.write("                            <td>\n");
      out.write("                            <input class=\"Text\" type=\"password\" name=\"EPassword\" pattern=\".{8,12}\" \n");
      out.write("                                   required title=\"8 to 12 characters\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Conform Password</b></td>\n");
      out.write("                            <td>\n");
      out.write("                            <input class=\"Text\" type=\"password\" name=\"CPassword\" pattern=\".{8,12}\" \n");
      out.write("                                   required title=\"8 to 12 characters\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                        <tr>\n");
      out.write("                            <td><input class=\"Button\" type=\"reset\" value=\"Cancel\" /></td>\n");
      out.write("                            <td><input class=\"Button\" type=\"submit\" value=\"Submit\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Side\"></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
