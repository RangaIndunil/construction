/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Services.CheckAccountInformation;
import Services.GetHardwareOwnerDetails;
import Services.GetTranspoterDetails;
import Services.UpdateDeveloperDetails;
import Services.UpdateHardwareOwnerDetails;
import Services.UpdateTranspoterDetails;
import Services.UpdateUserdetails;
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
@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

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
            out.println("<title>Servlet Update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        String UserName = (String) session.getAttribute("UName");
        String FirstName = request.getParameter("FName");
        String LastName = request.getParameter("LName");
        String BirthDay = request.getParameter("BirthDay");
        String Address = request.getParameter("Address");
        String Email = request.getParameter("Email");
        String Type = request.getParameter("Type");
        String Data = request.getParameter("Data");
        
        if(Data.equals("Basic")){
        
            CheckAccountInformation cai = new CheckAccountInformation();
        
            cai.setFirstName(FirstName);
            cai.setLastName(LastName);
            cai.setBirthDay(BirthDay);
            cai.setAddress(Address);
            cai.setEmail(Email);
        
            cai.CheckFirstName();
            cai.CheckLastName();
            cai.CheckBirthDay();
            cai.CheckAdderss();
            cai.CheckEmail();
        
            boolean value = cai.Check();
            
            if(!value){
                session.setAttribute("UMessage", "Please do not remove details "
                        + "which you dont want to update");
                
                RequestDispatcher requestDispatcher = 
    			request.getRequestDispatcher("/UpdateDetails.jsp");
                    requestDispatcher.forward(request, response);
            }else{
                UpdateUserdetails uud = new UpdateUserdetails();
                uud.login(UserName, FirstName, LastName, BirthDay, Address, Email);
                session.setAttribute("UDMessage", "details Updated");
            
                if(Type.equals("Customer")){
                    RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Dashboard.jsp");
                        requestDispatcher.forward(request, response);
                }else if(Type.equals("Developer")){
                    RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Developer.jsp");
                        requestDispatcher.forward(request, response);
                }else if(Type.equals("HardwareOwner")){
                    RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/HardwareOwner.jsp");
                        requestDispatcher.forward(request, response);
                }else if(Type.equals("Transpoter")){
                    RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Transpoter.jsp");
                        requestDispatcher.forward(request, response);
                }
            }
        
        }else if(Data.equals("Work")){
            session.setAttribute("UDMessage", "details Updated");
            
            if(Type.equals("Developer") || Type.equals("developer")){
                boolean Masson = false;
                boolean Tile = false;
                boolean Carpentor = false;
                boolean Plumber = false;
                boolean Electrician = false;
                boolean Painter = false;
                boolean ConcreteSlab = false;
                boolean Ceiling = false;
                boolean Welding = false;
                boolean Aluminium = false;
                
                Masson = Boolean.parseBoolean(request.getParameter("Masson"));
                Tile = Boolean.parseBoolean(request.getParameter("Tile"));
                Carpentor = Boolean.parseBoolean(request.getParameter("Carpentor"));
                Plumber = Boolean.parseBoolean(request.getParameter("Plumber"));
                Electrician = Boolean.parseBoolean(request.getParameter("Electrician"));
                Painter = Boolean.parseBoolean(request.getParameter("Painter"));
                ConcreteSlab = Boolean.parseBoolean(request.getParameter("ConcreteSlab"));
                Ceiling = Boolean.parseBoolean(request.getParameter("Ceiling"));
                Welding = Boolean.parseBoolean(request.getParameter("Welding"));
                Aluminium = Boolean.parseBoolean(request.getParameter("Aluminium"));
                
                UpdateDeveloperDetails udd = new UpdateDeveloperDetails();
                udd.login(UserName, Masson, Tile, Carpentor, Plumber, Electrician,
                         Painter, ConcreteSlab, Ceiling, Welding, Aluminium);
                
                RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Developer.jsp");
                        requestDispatcher.forward(request, response);
            }else if(Type.equals("HardwareOwner") || Type.equals("Hardwareowner")){
                
                String HardwareName = request.getParameter("Hardware Name");
                String HardwareAddress = request.getParameter("Hardware Address");
                
                GetHardwareOwnerDetails ghd = new GetHardwareOwnerDetails();
                ghd.SetDetails(UserName);
                
                String tempHardwareName = ghd.getHardwareName();
                String tempHardwareAddress = ghd.getHardwareAddress();
                
                if(HardwareName.equals(null) || HardwareName.equals("")){
                    HardwareName = tempHardwareName;
                }
                if(HardwareAddress.equals(null) || HardwareAddress.equals("")){
                    HardwareAddress = tempHardwareAddress;
                }
                
                UpdateHardwareOwnerDetails uhd = new UpdateHardwareOwnerDetails();
                uhd.login(UserName, HardwareName, HardwareAddress);
                
                RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/HardwareOwner.jsp");
                        requestDispatcher.forward(request, response);
            }else if(Type.equals("Transpoter") || Type.equals("transpoter")){
                
                String VehicleNumber = request.getParameter("Vehicle Number");
                String Model = request.getParameter("Model");
                String Chargeper1Km = request.getParameter("Charge per 1Km");
                
                GetTranspoterDetails gtd = new GetTranspoterDetails();
                gtd.SetDetails(UserName);
                
                String tempVehicleNumber = gtd.getVehicleNumber();
                String tempModel = gtd.getModel();
                String tempChargeper1Km = gtd.getCharge();
                
                if(VehicleNumber.equals(null) || VehicleNumber.equals("")){
                    VehicleNumber = tempVehicleNumber;
                    
                }
                if(Model.equals(null) || Model.equals("")){
                    Model = tempModel;
                }
                if(Chargeper1Km.equals(null) || Chargeper1Km.equals("")){
                    Chargeper1Km = tempChargeper1Km;
                }
                
                UpdateTranspoterDetails utd = new UpdateTranspoterDetails();
                String value = utd.login(UserName, VehicleNumber, Model, Chargeper1Km);
                
                RequestDispatcher requestDispatcher = 
                            request.getRequestDispatcher("/Transpoter.jsp");
                        requestDispatcher.forward(request, response);
            }
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
