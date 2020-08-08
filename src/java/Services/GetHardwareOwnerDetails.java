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
public class GetHardwareOwnerDetails {
    
    Connection con;
    Statement st;
    private String HardwareName;
    private String HardwareAddress;
    
    
    
    public void SetDetails(String uname){
        
        DBConnection();
        PreparedStatement pst;
    
        try {
            pst = con.prepareStatement("SELECT * FROM hardware WHERE HName=?");
            pst.setString(1, uname);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                HardwareName = rs.getString(1);
                rs.getString(2);
                HardwareAddress = rs.getString(3);
                
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHardwareName() {
        return HardwareName;
    }

    public String getHardwareAddress() {
        return HardwareAddress;
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
