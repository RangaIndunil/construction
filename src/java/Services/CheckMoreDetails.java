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
public class CheckMoreDetails {
    
    private boolean Mason;
    private boolean Tile;
    private boolean Carpentor;
    private boolean Plumber;
    private boolean Electrician;
    private boolean Painter;
    private boolean ConcreteSlab;
    private boolean Ceiling;
    private boolean Welding;
    private boolean Aluminium;
    private String HardwareName = "";
    private String HardwareAddress = "";
    private String VehicleNumber = "";
    private String Model = "";
    private String Chargeper1Km = "";
    
    private boolean Hvalue = false;
    private boolean Tvalue = false;
    
    public void SetDetails(boolean Mason,boolean Tile, boolean Carpentor, 
            boolean Plumber, boolean Electrician, boolean Painter, boolean ConcreteSlab, 
            boolean Ceiling, boolean Welding, boolean Aluminium, String HardwareName, 
            String HardwareAddress, String VehicleNumber, String Model, String Chargeper1Km){
        this.Mason = Mason;
        this.Tile = Tile;
        this.Carpentor =Carpentor; 
        this.Plumber = Plumber;
        this.Electrician = Electrician;
        this.Painter = Painter;
        this.ConcreteSlab = ConcreteSlab;
        this.Ceiling = Ceiling;
        this.Welding = Welding;
        this.Aluminium = Aluminium;
        this.HardwareName = HardwareName;
        this.HardwareAddress = HardwareAddress;
        this.VehicleNumber = VehicleNumber;
        this.Model = Model;
        this.Chargeper1Km = Chargeper1Km;
    }
    
    public boolean getDeveloperValue(){
        if(Mason){
            return true;
        }
        if(Tile){
            return true;
        }
        if(Carpentor){
            return true;
        }
        if(Plumber){
            return true;
        }
        if(Electrician){
            return true;
        }
        if(Painter){
            return true;
        }
        if(ConcreteSlab){
            return true;
        }
        if(Ceiling){
            return true;
        }
        if(Welding){
            return true;
        }
        if(Aluminium){
            return true;
        }
        return false;
    }
    
    public boolean getHardwareOwnerValue(){
        if(HardwareName.equals(null) || HardwareName.equals("")){
            Hvalue = false;
        }else{
            Hvalue = true;
        }
        if(HardwareAddress.equals(null) || HardwareAddress.equals("")){
            Hvalue = false;
        }else{
            Hvalue = true;
        }
        return Hvalue;
    }
    
    public boolean getTranspoterValue(){
        if(VehicleNumber.equals(null) || VehicleNumber.equals("")){
            Tvalue = false;
        }else{
            Tvalue = true;
        }
        if(Model.equals(null) || Model.equals("")){
            Tvalue = false;
        }else{
            Tvalue = true;
        }
        if(Chargeper1Km.equals(null) || Chargeper1Km.equals("")){
            Tvalue = false;
        }else{
            Tvalue = true;
        }
        return Tvalue;
    }
    
}
