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
public class GetDeveloperDetails {
    
    Connection con;
    Statement st;
    private boolean Mason = false;
    private boolean Tile = false;
    private boolean Carpentor = false;
    private boolean Plumber = false;
    private boolean Electrician = false;
    private boolean Painter = false;
    private boolean ConcreteSlab = false;
    private boolean Ceiling = false;
    private boolean Welding = false;
    private boolean Aluminium = false;
    
    
    
    public void SetDetails(String uname){
        
        DBConnection();
        PreparedStatement pst;
    
        try {
            pst = con.prepareStatement("SELECT * FROM developer WHERE DName=?");
            pst.setString(1, uname);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rs.getString(1);
                Mason = rs.getBoolean(2);
                Ceiling = rs.getBoolean(3);
                Tile = rs.getBoolean(4);
                Carpentor = rs.getBoolean(5);
                Plumber = rs.getBoolean(6);
                Electrician = rs.getBoolean(7);
                Painter = rs.getBoolean(8);
                Aluminium = rs.getBoolean(9);
                ConcreteSlab = rs.getBoolean(10);
                Welding = rs.getBoolean(11);
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isMason() {
        return Mason;
    }

    public boolean isTile() {
        return Tile;
    }

    public boolean isCarpentor() {
        return Carpentor;
    }

    public boolean isPlumber() {
        return Plumber;
    }

    public boolean isElectrician() {
        return Electrician;
    }

    public boolean isPainter() {
        return Painter;
    }

    public boolean isConcreteSlab() {
        return ConcreteSlab;
    }

    public boolean isCeiling() {
        return Ceiling;
    }

    public boolean isWelding() {
        return Welding;
    }

    public boolean isAluminium() {
        return Aluminium;
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
