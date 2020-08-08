/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Singer
 */
public class SetDashboarddata {
    Connection con;
    Statement st;
    
    private String poto = "";
    
    public String getData(String uname){
    
        DBConnection();
        PreparedStatement pst;
    
        try {
            pst = con.prepareStatement("SELECT Photo FROM userdetails WHERE UserName=?");
            pst.setString(1, uname);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                poto = rs.getString(1);
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return poto;
    }
        
    private void DBConnection(){
        String path = "jdbc:mysql://localhost:3306/constructiondb";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(path,"root","");
            st =  con.createStatement();
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
