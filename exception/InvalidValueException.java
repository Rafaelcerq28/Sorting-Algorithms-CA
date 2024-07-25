package exception;

import javax.swing.JOptionPane;

public class InvalidValueException extends Exception{
    String msg;
    
    //constructors
    public InvalidValueException(){

    }

    public InvalidValueException(String msg) {
        super(msg);
        this.msg = msg;
    }

    //method to return a messageDialog with a message
    public void exceptionMessage (InvalidValueException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
    //when the system throw an InvalidValueException().digitsOnlyFuel() 
    //this block return a InvalidValueException with the message
    public static InvalidValueException digitsOnlyFuel(){
        return new InvalidValueException("This field cant be only numbers");
    }

    //when the system throw an InvalidValueException().blankField() 
    //this block return a InvalidValueException with the message
    public static InvalidValueException blankField(){
        return new InvalidValueException("This field cannot be empty");
    }

    //when the system throw an InvalidValueException().zeroOrBellow() 
    //this block return a InvalidValueException with the message
    public static InvalidValueException zeroOrBellow(){
        return new InvalidValueException("This field cannot be zero or negative");
    }
}
