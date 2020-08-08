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
public class LoginAccount {
    
    Connection con;
    Statement st;
    
    public boolean SetDetails(String UserName, String Password){
        
        DBConnection();
        PreparedStatement pst;
        boolean value = false;
    
        try {
            pst = con.prepareStatement("SELECT * FROM userdetails WHERE UserName=?"
                    + " AND PASSWORD=?");
            pst.setString(1, UserName);
            pst.setString(2, Password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                value = true;
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return value;
    }
    
    private void DBConnection(){
        String path = "jdbc:mysql://localhost:3306/constructiondb";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(path,"root","");
            st =  con.createStatement();
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
