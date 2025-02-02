import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class has the purpouse of load the data from a csv file and 
 * return an array of a chosen amount and a list of locations
 */
public class VehiclesLoader {

    //This method returns a list of vehicles from a determided size
    Sorting<Vehicles> loadData(int stopAt) throws FileNotFoundException{
        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//vehicles.csv";
        //Vehicles[] vehicle;
        Sorting<Vehicles> vehicles = new Sorting<>();

        try (Scanner scanner = new Scanner(new File(name))) {

            // this will just print the header in CSV file
            scanner.nextLine();
            int i = 0;
            String sGetData;
            int iterator = 0;
            while (scanner.hasNextLine()) {

                //this if is to stop adding vehicles on my list
                if (iterator == stopAt) {
                    break;
                }
                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                vehicles.add(new Vehicles(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Long.parseLong(data[5])));
                
                iterator++;
            }
            //closes the scanner
        }

        return vehicles;
    }

    //this method return a list of Strings containing only the location column
    Sorting<String> loadColumData() throws FileNotFoundException{
        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//vehicles.csv";
        //Vehicles[] vehicle;
        Sorting<Vehicles> vehicles = new Sorting<>();

        try (Scanner scanner = new Scanner(new File(name))) {

            // this will just print the header in CSV file
            scanner.nextLine();
            String sGetData;
            while (scanner.hasNextLine()) {

                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                vehicles.add(new Vehicles(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Long.parseLong(data[5])));
            }
            //closes the scanner
        }

        Sorting<String> location = new Sorting<>();
        for (Vehicles vehicle : vehicles) {
            location.add(vehicle.getsLocation());
        }

        return location;
    }

}
