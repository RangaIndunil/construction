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
public class GetMobile {
    Connection con;
    Statement st;
    
    private static String[] Numbers = new String[10];
    
    private boolean value = false;
        
    public void SetDetails(String uname){
        
        DBConnection();
        PreparedStatement pst;
        
        for(int i = 0; i <10; i ++){
            Numbers[i] = "No";
        }
        
        try {
            
            if(!value){
                
                pst = con.prepareStatement("SELECT * FROM `customermobile` WHERE UserName=?");
                pst.setString(1, uname);
                
                ResultSet rsc = pst.executeQuery();
                
                int counter = 0;
                while(rsc.next()){
                    rsc.getString(1);
                    Numbers[counter] = rsc.getString(2);
                    counter++;
                }
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] getNumbers() {
        return Numbers;
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
