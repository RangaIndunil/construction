/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controler.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Singer
 */
public class UserNameAveilability {
    
    Connection con;
    Statement st;
    
    public boolean check(String uname){
    
        boolean status = false;
        DBConnection();
        PreparedStatement pst;
    
        try {
            pst = con.prepareStatement("SELECT * FROM userdetails WHERE UserName=?");
            pst.setString(1, uname);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                status = false;
            }
            else{
                status = true;
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
        
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
