package exception;

import javax.swing.JOptionPane;

public class InvalidValueException extends Exception{
    String msg;
    
    public InvalidValueException(){

    }

    public InvalidValueException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public void exceptionMessage (InvalidValueException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
    public static InvalidValueException digitsOnlyFuel(){
        return new InvalidValueException("This field cannot have a empty value!");
    }

    public static InvalidValueException blankField(){
        return new InvalidValueException("This field cannot be empty");
    }

    public static InvalidValueException zeroOrBellow(){
        return new InvalidValueException("This field cannot be zero or negative");
    }
}
