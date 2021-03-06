package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Services.GetAccountDetails;
import Services.SetDashboarddata;
import Services.GetAccountDetails;
import java.util.Enumeration;

public final class Dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Dashboard Page</title>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"Dashboard.css\">\n");
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
      out.write("        ");

            String UserName = (String) session.getAttribute("UName");
            session.setAttribute("UMessage", "No");
            SetDashboarddata sd = new SetDashboarddata();
            GetAccountDetails gad = new GetAccountDetails();
            String url = "Poto\\" + sd.getData(UserName).toString();
            gad.SetDetails(UserName);
            String Name = gad.getName();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"Side1\"></div>\n");
      out.write("        <div id=\"Div1\">\n");
      out.write("            <br>\n");
      out.write("            <center><img src=\"");
      out.print(url);
      out.write("\" width=\"230\" height=\"300\"/></center>\n");
      out.write("            <center><p>\n");
      out.write("                <h3>");
      out.print(Name);
      out.write("</h3>\n");
      out.write("            </p></center>\n");
      out.write("            <center><a href=\"UpdateDetails.jsp\">Update Details</a></center>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Side1\"></div>\n");
      out.write("        ");

            String UMessage = (String) session.getAttribute("UDMessage");
            if(!UMessage.equals("No")){
                session.setAttribute("UDMessage", "No");
        
      out.write("\n");
      out.write("        <div id=\"Side3\"></div>\n");
      out.write("        <div id=\"Div3\">\n");
      out.write("            <center><h4>");
      out.print(UMessage);
      out.write("</h4></center>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Side3\"></div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <div id=\"Side2\"></div>\n");
      out.write("        <div id=\"Div2\">\n");
      out.write("            <form action=\"DashboardProcess\" method=\"POST\">\n");
      out.write("                <center><table class=\"table\" align=\"center\" border=\"0\">\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Enter Location</b></td>\n");
      out.write("                            <td><input class=\"Text\" type=\"text\" name=\"Location\" value=\"\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><b>Select Type</b></td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"type\" value=\"developer\" checked=\"checked\"/> \n");
      out.write("                                <b>Developer</b><br>\n");
      out.write("                                <input type=\"radio\" name=\"type\" value=\"hardwareowner\" /> \n");
      out.write("                                <b>Hardware Owner</b><br>\n");
      out.write("                                <input type=\"radio\" name=\"type\" value=\"transpoter\" /> \n");
      out.write("                                <b>Transporter</b>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table></center>\n");
      out.write("                <center>\n");
      out.write("                    <input class=\"Button\" type=\"submit\" value=\"Search\" />\n");
      out.write("                </center>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Side2\"></div>\n");
      out.write("                    \n");
      out.write("        ");

            String FMessage = (String) session.getAttribute("FMessage");
            session.setAttribute("FMessage", "");
            if(!FMessage.equals("")){
        
      out.write("\n");
      out.write("        <div id=\"Side3\"></div>\n");
      out.write("        <div id=\"Div3\">\n");
      out.write("            <center><p><b>");
      out.print(FMessage);
      out.write("</b></p></center>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Side3\"></div>\n");
      out.write("        ");

            }
        
      out.write("\n");
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
