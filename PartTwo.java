import java.io.FileNotFoundException;
import java.util.ArrayList;

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


    Vehicles vehicle = new Vehicles(id, name, fuel, Location, Postcode, value);
}

}
