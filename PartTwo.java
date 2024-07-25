import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.InvalidValueException;
import exception.VehicleException;

public class PartTwo {

public static void main(String[] args) throws FileNotFoundException {

    //instantiate the class VehiclesLoader
    VehiclesLoader loader = new VehiclesLoader();

    //stores the vehicles in an array
    ArrayList<Vehicles> vehicles = loader.loadData(10000);

    //Example to be stored in my list
    //(10001,Fiat,Petrol,Dublin,1634,942) 

    //variables
    int id = 0;
    String name = "";
    String fuel = "";
    String location = "";
    int postcode = 0;
    Long value = (long) 0;

    //try block to catch my exceptions
    try{
        //get the id from the user      
        id = Integer.parseInt(JOptionPane.showInputDialog("Insert your id"));       
        //validate this ID checking if it is smaller than the last it in my list
        if(id <= vehicles.get(vehicles.size() -1).getiId()){            
            throw new VehicleException();
        }

        //get the name from the user
        name = JOptionPane.showInputDialog("Insert your name");
        //check if the name is empty and if the user put only numbers
        if(name.isBlank()){
            throw new InvalidValueException().blankField();
        }else if(name.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        //get the fuel from the user
        fuel = JOptionPane.showInputDialog("Insert your fuel");
        //check if the fuel is empty and if the user put only numbers
        if(fuel.isBlank()){
            throw new InvalidValueException().blankField();
        }else if(fuel.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        //get the location from the user
        location = JOptionPane.showInputDialog("Insert your Location");
        //check if the location is empty and if the user put only numbers
        if(location.isBlank()){
            throw new InvalidValueException().blankField();
        }else if(location.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        //get the postcode from the user
        postcode = Integer.parseInt(JOptionPane.showInputDialog("Insert your Postcode"));
        //check if the value is below zero
        if(postcode <= 0){
            throw new InvalidValueException().zeroOrBellow();
        }

        //get the value from the user
        value = Long.parseLong((JOptionPane.showInputDialog("Insert your value")));
        //check if the value is below zero
        if(value < 0){
            throw new InvalidValueException().zeroOrBellow();
        }

        //if there is no errors create a new vehicle and add into the list
        Vehicles vehicle = new Vehicles(id, name, fuel, location, postcode, value);

        //adding the vehicles in the list and showing a message informing the user
        vehicles.add(vehicle);
        JOptionPane.showMessageDialog(null, "Vehicle added in the list");
        
        //printing the list to show the new vehicle
        System.out.println(vehicles.get(vehicles.size()-3));
        System.out.println(vehicles.get(vehicles.size()-2));
        System.out.println(vehicles.get(vehicles.size()-1));

    //catch methods
    //Exception created to return an error when the id is already in use
    }catch(VehicleException e){
        e.userAlreadyExists();
    //Exception created to return errors when a wrong data is added
    }catch(InvalidValueException e){
        e.exceptionMessage(e);
    //Java exception when a string is typed in a int field 
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Only numbers are allowed in this field");
    }
    
}

}
