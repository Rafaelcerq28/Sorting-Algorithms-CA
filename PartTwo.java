import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.InvalidValueException;
import exception.VehicleException;

public class PartTwo {
//     Write a Java program that accepts a new record (with all the six fields) and adds it at the
// end of the record array, with a new consecutive ID number. 

public static void main(String[] args) throws FileNotFoundException {
    VehiclesLoader loader = new VehiclesLoader();

    ArrayList<Vehicles> vehicles = loader.loadData(10000);

    System.out.println(vehicles.get(9999));
    // (10001,Fiat,Petrol,Dublin,1634,942) 

    int id = 0;
    String name = "";
    String fuel = "";
    String Location = "";
    int Postcode = 0;
    Long value = (long) 0;

    try{      
        id = Integer.parseInt(JOptionPane.showInputDialog("Insert your id"));
        
        if(id <= vehicles.get(vehicles.size() -1).getiId()){            
            throw new VehicleException();
        }

        name = JOptionPane.showInputDialog("Insert your name");
        if(name.isBlank()){
            throw new InvalidValueException("This field cannot be blank");
        }else if(name.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        fuel = JOptionPane.showInputDialog("Insert your fuel");
        if(fuel.isBlank()){
            throw new InvalidValueException().blankField();
        }else if(fuel.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        Location = JOptionPane.showInputDialog("Insert your Location");
        if(Location.isBlank()){
            throw new InvalidValueException().blankField();
        }else if(Location.matches("\\d+") == true){
            throw new InvalidValueException().digitsOnlyFuel();
        }

        Postcode = Integer.parseInt(JOptionPane.showInputDialog("Insert your Postcode"));
        
        value = Long.parseLong((JOptionPane.showInputDialog("Insert your value")));
        if(value <= 0){
            throw new InvalidValueException().zeroOrBellow();
        }
        Vehicles vehicle = new Vehicles(id, name, fuel, Location, Postcode, value);

        vehicles.add(vehicle);

    }catch(VehicleException e){
        e.userAlreadyExists();
    }catch(InvalidValueException e){
        e.exceptionMessage(e);
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Only numbers are allowed in this field");
    }
    
    

}

}
