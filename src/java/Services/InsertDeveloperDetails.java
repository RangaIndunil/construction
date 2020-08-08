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
public class InsertDeveloperDetails {
    
    Statement stmt;
    
    public String setDetails(String UserName, boolean Mason,boolean Tile, 
            boolean Carpentor, boolean Plumber, boolean Electrician, boolean Painter, 
            boolean ConcreteSlab, boolean Ceiling, boolean Welding, boolean Aluminium){
        
        String Status = "Insert details starting";
        DBConnection();
        
        String query = "UPDATE developer SET isMason = "+Mason+", isCelling = "+Ceiling
                +", isTile = "+Tile+", isCarpentor = "+Carpentor+", isPlumber = "+Plumber
                +", isElectrician = "+Electrician+", isPainter = "+Painter+", isAluminium = "
                +Aluminium+", isConcreate = "+ConcreteSlab+", isWelding = "
                +Welding+" WHERE DName = '"+UserName+"'";
        //String query = "UPDATE developer SET isMason = '"+1+"' WHERE DName = 'Kasun'";
        
        try {
            
            stmt.executeUpdate(query);
            Status = "Insert details starting ok";
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Status;
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
