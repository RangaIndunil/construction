package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Services.GetAccountDetails;
import java.util.Enumeration;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"Home.css\">\n");
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
      out.write("        <div class=\"description\">\n");
      out.write("                <h3>\n");
      out.write("                    Welcome to Super Construction\n");
      out.write("                </h3>\n");
      out.write("                <h5>\n");
      out.write("                    Our Web site makes easier for the people for their day today \n");
      out.write("                    activities in Construction Field. User can register as \n");
      out.write("                    Customer, Developer, Hardware Owner or Transporter. Initially\n");
      out.write("                    to access this Website if you are a Customer you have to make \n");
      out.write("                    a New Account as Customer. Then Login. Also the Developer, \n");
      out.write("                    Hardware Owner or Transporter can create an Account and Advertise\n");
      out.write("                    their Product and Service. Customers can hire Developers, \n");
      out.write("                    Hardware Owners or Transporters according to their Prices and \n");
      out.write("                    Ratings given other Customers. Also Customers can give their \n");
      out.write("                    own Feedback regarding the Products and Services.\n");
      out.write("                </h5>\n");
      out.write("        </div>\n");
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
