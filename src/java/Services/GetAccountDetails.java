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
public class GetAccountDetails {
    
    Connection con;
    Statement st;
    private String Name;
    private String FName;
    private String LName;
    private String Birthday;
    private String Address;
    private String City;
    private String Email;
    private String Mobile;
    private String Password;
    private String Type;
        
    public void SetDetails(String uname){
        
        DBConnection();
        PreparedStatement pst;
        PreparedStatement pstc;
        PreparedStatement pstd;
        PreparedStatement pstt;
        PreparedStatement psth;
    
        try {
            pst = con.prepareStatement("SELECT * FROM userdetails WHERE UserName=?");
            pst.setString(1, uname);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rs.getString(1);
                FName = rs.getString(2);
                LName = rs.getString(3);
                Address =rs.getString(4);
                Password = rs.getString(5);
                Email = rs.getString(6);
                Birthday = rs.getString(7);
                Name = FName + " " + LName;
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getType() {
        return Type;
    }

    public String getName() {
        return Name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile() {
        return Mobile;
    }
    public String getPassword() {
        return Password;
    }
    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
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
