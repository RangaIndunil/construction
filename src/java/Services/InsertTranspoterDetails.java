/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Singer
 */
public class InsertTranspoterDetails {
    
    Statement stmt;
    
    public void setDetails(String UserName, String VehicleNumber, String Model, String Chargeper1Km){
    
        DBConnection();
        String query = "INSERT INTO vehicle VALUES ('"+VehicleNumber+"','"
                +UserName+"','"+Chargeper1Km+"','"+Model+"')";
        
        try {
            
            stmt.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void DBConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String path = "jdbc:mysql://localhost:3306/constructiondb";
        
        try {
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(path,"root","");
            stmt = con.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
