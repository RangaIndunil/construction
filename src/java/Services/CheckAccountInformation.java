/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Singer
 */
public class CheckAccountInformation {
    
    private String FirstName = "";
    private String LastName = "";
    private String UserName = "";
    private String BirthDay = "";
    private String Address = "";
    private String City = "";
    private String Email = "";
    private String Mobile = "";
    private String Password = "";
    private String tempPassword = "";
    private String type = "";

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    boolean mis = true;
    
    public void CheckType(){
        if(type.equals("") || type.equals(null)){
            mis = false;
        }
    }
    public void CheckFirstName(){
         if(FirstName.equals("") || FirstName.equals(null)){
            mis = false;
        }
    }
    public void CheckLastName(){
        if(LastName.equals("") || LastName.equals(null)){
            mis = false;
        }
    }
    public void CheckUserName(){
        if(UserName.equals("") || UserName.equals(null)){
            mis = false;
        }
    }
    public void CheckBirthDay(){
        if(BirthDay.equals("") || BirthDay.equals(null)){
            mis = false;
        }
    }
    public void CheckAdderss(){
        
        if(Address.equals("") || Address.equals(null)){
            mis = false;
        }
    }
    public void CheckCity(){
        if(City.equals("") || City.equals(null)){
            mis = false;
        }
    }
    public void CheckEmail(){
        if(Email.equals("") || Email.equals(null)){
            mis = false;
        }
    }
    public void CheckMobile(){
        if(Mobile.equals("") || Mobile.equals(null)){
            mis = false;
        }
    }
    public boolean Check(){
        return mis;
    }
    
}
