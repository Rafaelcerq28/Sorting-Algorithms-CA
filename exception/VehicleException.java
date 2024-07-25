package exception;

import javax.swing.JOptionPane;

public class VehicleException extends Exception{

    String msg;
    
    //Constructors
    public VehicleException() {
    }

    public VehicleException(String msg){
        super(msg);
        this.msg = msg;
    }

    //Exception when the user exists
    public void userAlreadyExists(){
        JOptionPane.showMessageDialog(null, "This ID is already in use or invalid");
    }
}
