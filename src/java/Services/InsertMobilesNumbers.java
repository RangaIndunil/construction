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
public class InsertMobilesNumbers {
    
    Statement stmt;
    String[] queries = new String[10];
    boolean condition = true;
    String status = "false";
    
    public String login(String UserName, String[] Numbers){
    
        DBConnection();
        
        for (int i = 0; i < Numbers.length; i++) {
            String Number = "";
            try{
                if(Numbers[i].equals(null) || Numbers[i].equals("")){
                    break;
                }
            }catch(NullPointerException e){
                break;
            }
            Number = Numbers[i];
            queries[i] = "INSERT INTO customermobile (UserName, Mobile) VALUES ('"+UserName+"','"
                    +Number+"')";
        }
        try {
            for (int j = 0; j < queries.length; j++) {
                try{
                    if(queries[j].equals(null) || queries[j].equals("")){
                        break;
                    }
                }catch(NullPointerException e){
                    break;
                }
                stmt.executeUpdate(queries[j]);
                status += " true";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
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
