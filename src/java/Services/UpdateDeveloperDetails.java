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
public class UpdateDeveloperDetails {
    Statement stmt;
    
    public void login(String UserName, boolean Masson, boolean Tile, boolean Carpentor
    , boolean Plumber, boolean Electrician, boolean Painter, boolean Concrete_slab
    , boolean Ceiling, boolean Welding, boolean Aluminium){
    
        DBConnection();
        String query = "UPDATE developer SET isMason="+Masson+", isTile="+Tile+
                ", isCarpentor="+Carpentor+", isPlumber="+Plumber+", isElectrician="
                +Electrician+", isPainter="+Painter+", isConcreate="+Concrete_slab
                +", isCelling="+Ceiling+", isWelding="+Welding+", isAluminium="
                +Aluminium+" WHERE DName='"+UserName+"'";
        
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
