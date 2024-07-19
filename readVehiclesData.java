import java.io.File;
import java.util.*;

public class readVehiclesData {

    public static void main(String[] args) throws Exception {

        VehiclesLoader loader = new VehiclesLoader();
        Sorting<Vehicles> vehicles = (Sorting<Vehicles>) loader.loadData(10000);
        
        // Check if the data was loaded
        System.out.println(vehicles.size());


        System.out.println("Before sort");
        for(int i=0;i<vehicles.size();i++){
            System.out.println(vehicles.get(i));
        }
        
        // vehicles.simpleBubbleSort();
        // vehicles.quickSort(0, vehicles.size() -1);
        // vehicles.mergeSort(0, vehicles.size() -1);
        //  vehicles.insertionSort();

        System.out.println("After sort");
        for(int i=0;i<vehicles.size();i++){
            System.out.println(vehicles.get(i));
        }
    }

}

