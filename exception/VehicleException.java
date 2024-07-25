package exception;

import javax.swing.JOptionPane;

public class VehicleException extends Exception{

    String msg;

    public VehicleException() {
        //empty constructor
    }

    public VehicleException(String msg){
        super(msg);
        this.msg = msg;
    }

    public void userAlreadyExists(){
        JOptionPane.showMessageDialog(null, "This ID is already in use");
        //return this.msg;
    }
}
