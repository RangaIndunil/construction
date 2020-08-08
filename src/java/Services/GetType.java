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
 * @author User
 */
public class GetType {
    Connection con;
    Statement st;
    
    private String Type;
    
    private boolean value = false;
        
    public void SetDetails(String uname){
        
        DBConnection();
        PreparedStatement pstc;
        PreparedStatement pstd;
        PreparedStatement pstt;
        PreparedStatement psth;
    
        try {
            
            if(!value){
                
                pstc = con.prepareStatement("SELECT * FROM coustomer WHERE CName=?");
                pstc.setString(1, uname);
                
                ResultSet rsc = pstc.executeQuery();
            
                if(rsc.next()){
                    Type = "coustomer";
                    value = true;
                }
            }
            
            if(!value){
                
                pstd = con.prepareStatement("SELECT * FROM developer WHERE DName=?");
                pstd.setString(1, uname);
                
                ResultSet rsd = pstd.executeQuery();
                       
                if(rsd.next()){
                    Type = "Developer";
                    value = true;
                }
            
            }
            
            if(!value){
                
                pstt = con.prepareStatement("SELECT * FROM transpoter WHERE TName=?");
                pstt.setString(1, uname);
                
                ResultSet rst = pstt.executeQuery();
            
                if(rst.next()){
                    Type = "Transpoter";
                    value = true;
                }
            
            }
            
            if(!value){
                
                psth = con.prepareStatement("SELECT * FROM hardwareowner WHERE HName=?");
                psth.setString(1, uname);
                
                ResultSet rsh = psth.executeQuery();
            
                if(rsh.next()){
                    Type = "Hardwareowner";
                    value = true;
                }
            
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getType() {
        return Type;
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
