/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Services.GetAccountDetails;
import Services.GetType;
import Services.LoginAccount;
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
@WebServlet(name = "LoginControler", urlPatterns = {"/LoginControler"})
public class LoginControler extends HttpServlet {

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
            out.println("<title>Servlet LoginControler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginControler at " + request.getContextPath() + "</h1>");
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
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");
        session.setAttribute("UDMessage", "No");
        session.setAttribute("FMessage", "No");
        session.setAttribute("UName",UserName);
        
        LoginAccount la = new LoginAccount();
        boolean value = la.SetDetails(UserName, Password);
        
        if(value){
                        
            GetType gt = new GetType();
            gt.SetDetails(UserName);
            
            String Type = gt.getType();
            
            if(Type.equals("coustomer") || Type.equals("Coustomer")){
                
                RequestDispatcher requestDispatcher = 
            		request.getRequestDispatcher("/Dashboard.jsp");
                requestDispatcher.forward(request, response);
            }else if(Type.equals("developer") || Type.equals("Developer")){
                RequestDispatcher requestDispatcher = 
            		request.getRequestDispatcher("/Developer.jsp");
                requestDispatcher.forward(request, response);
            }else if(Type.equals("hardwareowner") || Type.equals("Hardwareowner")){
                RequestDispatcher requestDispatcher = 
            		request.getRequestDispatcher("/HardwareOwner.jsp");
                requestDispatcher.forward(request, response);
            }else if(Type.equals("transpoter") || Type.equals("Transpoter")){
                RequestDispatcher requestDispatcher = 
            		request.getRequestDispatcher("/Transpoter.jsp");
                requestDispatcher.forward(request, response);
            }
        }else{
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<center><h4>");
            out.println("Please enter correct User Name and Password");
            out.println("</h4></center>");
            out.println("</body></html>");
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/LoginPage.jsp");
    		requestDispatcher.include(request, response);
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
