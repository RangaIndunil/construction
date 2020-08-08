/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Services.CheckMoreDetails;
import Services.GetAccountDetails;
import Services.InsertDeveloperDetails;
import Services.InsertHardwareOwnerDetails;
import Services.InsertTranspoterDetails;
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
@WebServlet(name = "SetMoreDetails", urlPatterns = {"/SetMoreDetails"})
public class SetMoreDetails extends HttpServlet {

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
            out.println("<title>Servlet SetMoreDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SetMoreDetails at " + request.getContextPath() + "</h1>");
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
        String UserName = (String) session.getAttribute("UName");
        session.setAttribute("Message", "You have successfully created your account");
        
        String Status = "False";
        String Type = (String)session.getAttribute("Type");
        session.setAttribute("Type", Type);
        session.setAttribute("UName", UserName);
        
        boolean Mason = false;
        boolean Tile = false;
        boolean Carpentor = false;
        boolean Plumber = false;
        boolean Electrician = false;
        boolean Painter = false;
        boolean ConcreteSlab = false;
        boolean Ceiling = false;
        boolean Welding = false;
        boolean Aluminium = false;
        String HardwareName = "";
        String HardwareAddress = "";
        String VehicleNumber = "";
        String Model = "";
        String Chargeper1Km = "";
        
        try{
            if(!request.getParameter("Masson").equals(null) || 
                    !request.getParameter("Masson").equals("")){
                Mason = Boolean.parseBoolean(request.getParameter("Masson"));
                Tile = Boolean.parseBoolean(request.getParameter("Tile"));
                Carpentor = Boolean.parseBoolean(request.getParameter("Carpentor"));
                Plumber = Boolean.parseBoolean(request.getParameter("Plumber"));
                Electrician = Boolean.parseBoolean(request.getParameter("Electrician"));
                Painter = Boolean.parseBoolean(request.getParameter("Painter"));
                ConcreteSlab = Boolean.parseBoolean(request.getParameter("ConcreteSlab"));
                Ceiling = Boolean.parseBoolean(request.getParameter("Ceiling"));
                Welding = Boolean.parseBoolean(request.getParameter("Welding"));
                Aluminium = Boolean.parseBoolean(request.getParameter("Aluminium"));
            }
        }catch(NullPointerException e){
            System.out.println("Not developer details");
        }
        
        try{
            if(!request.getParameter("Hardware Name").equals(null) ||
                    !request.getParameter("Hardware Name").equals("")){
                HardwareName = request.getParameter("Hardware Name");
                HardwareAddress = request.getParameter("Location");
            }
        }catch(NullPointerException e){
            System.out.println("Not developer details");
        }
        
        try{
            if(request.getParameter("Vehicle Number").equals(null) || 
                    !request.getParameter("Vehicle Number").equals("")){
                VehicleNumber = request.getParameter("Vehicle Number");
                Model = request.getParameter("Model");
                Chargeper1Km = request.getParameter("Charge per 1Km");
            }
        }catch(NullPointerException e){
            System.out.println("Not developer details");
        }
        
        
        CheckMoreDetails cmd = new CheckMoreDetails();
        cmd.SetDetails(Mason, Tile, Carpentor, Plumber, Electrician, Painter, 
                ConcreteSlab, Ceiling, Welding, Aluminium, HardwareName, 
                HardwareAddress, VehicleNumber, Model, Chargeper1Km);
        
        if(cmd.getDeveloperValue()){
            
            InsertDeveloperDetails idd = new InsertDeveloperDetails();
            Status = idd.setDetails(UserName, Mason, Tile, Carpentor, Plumber, Electrician, 
                    Painter, ConcreteSlab, Ceiling, Welding, Aluminium);
                
            session.setAttribute("Status", Status);
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/CreatedAccount.jsp");
            requestDispatcher.forward(request, response);
        }
        if(cmd.getHardwareOwnerValue()){
            
            InsertHardwareOwnerDetails ihod = new InsertHardwareOwnerDetails();
            ihod.setDetails(UserName, HardwareName, HardwareAddress);
            
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/CreatedAccount.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(cmd.getTranspoterValue()){
            
            InsertTranspoterDetails itd = new InsertTranspoterDetails();
            itd.setDetails(UserName, VehicleNumber, Model, Chargeper1Km);
            
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/CreatedAccount.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            if(Type.equals("developer")){
                out.println("<!DOCTYPE html>");
                out.println("<html><body>");
                out.println("Are you a Developer please fill your form.");
                out.println("</body></html>");
            }
            else{
                out.println("Please enter all details");
            }
            RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/MoreDetails.jsp");
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
