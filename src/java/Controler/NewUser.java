/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Services.CheckAccountInformation;
import Services.InsertData;
import Services.InsertMobilesNumbers;
import Services.UserNameAveilability;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Singer
 */
@WebServlet(name = "NewUser", urlPatterns = {"/NewUser"})
public class NewUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // gets values of text fields
        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String UserName = request.getParameter("UserName");
        String BirthDay = request.getParameter("BirthDay");
        String Address = request.getParameter("Address");
        String City = request.getParameter("City");
        String Email = request.getParameter("Email");
        String Mobile = request.getParameter("Mobile");
        String Password = request.getParameter("EPassword");
        String tempPassword = request.getParameter("CPassword");
        String type = request.getParameter("type");
        String[] Numbers = new String[10];
        String Status = "";
        if (!(request.getParameter("Mobile0")).equals("") || !(request.getParameter("Mobile0")).equals(null)) {
            for (int counter = 0 ; counter < Numbers.length;  counter ++) {
                String tempcounter = Integer.toString(counter);
                try{
                    if ((request.getParameter("Mobile" + tempcounter)).equals("") || 
                            (request.getParameter("Mobile" + tempcounter)).equals(null)) {
                        break;
                    }
                    }catch(NullPointerException e){
                        break;
                    }
                Numbers[counter] = request.getParameter("Mobile" + tempcounter);
            }
            System.out.println("Mobile numbers get array ok");
        }
        
        //To check both password equals
        if(!Password.equals(tempPassword)){
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("Please enter both same password " + UserName);
            out.println("</body></html>");
            System.out.println("Password is not equals");
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/CreateAccount.jsp");
    		requestDispatcher.include(request, response);
        }
        
        //To Check UserName avelibility
        UserNameAveilability get = new UserNameAveilability();
        
        if(!get.check(UserName)){
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("Please enter another user name it has already used");
            out.println("</body></html>");
            System.out.println("User name already used");
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/CreateAccount.jsp");
    		requestDispatcher.include(request, response);
        }
        
        //To insert new user details
        else{
            InsertData newuser = new InsertData();
            newuser.login(FirstName, LastName, UserName, BirthDay, Address, City, Email, Mobile, Password, type);
            System.out.println("Insert user basic details");
            Status = "false";
            if (Numbers.length > 0) {
                InsertMobilesNumbers imn = new InsertMobilesNumbers();
                Status = imn.login(UserName, Numbers);
                System.out.println("Insert user mobile numbers");
            }
            HttpSession session = request.getSession();
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("Successfully Inserted your Information");
            out.println("</body></html>");
            session.setAttribute("UName", UserName);
            session.setAttribute("Type", type);
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/AddPoto.jsp");
            requestDispatcher.forward(request, response);
        }

        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
