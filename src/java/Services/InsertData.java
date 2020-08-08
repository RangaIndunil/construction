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
public class InsertData {
    
    Statement stmt;
    
    public void login(String FirstName,String LastName, String UserName, String BirthDay
    , String Address, String City, String Email, String Mobile, String Password, String type){
    
        DBConnection();
        String query = "INSERT INTO userdetails (UserName, FirstName, LastName, "
                + "Address, PASSWORD, Email, Birthday) VALUES ('"+UserName+"','"
                +FirstName+"','"+LastName+"','"+Address+"','"+Password+"','"
                +Email+"','"+BirthDay+"')";
        
        String CName ="";
        if(type.equals("coustomer")){
            CName = "CName";
        }
        if(type.equals("developer")){
            CName = "DName";
        }
        if(type.equals("transpoter")){
            CName = "TName";
        }
        if(type.equals("hardwareowner")){
            CName = "HName";
        }
        
        String query2 = "INSERT INTO " + type + "("+ CName +") VALUES ('"+ UserName +"')";
        
        try {
            
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            
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
