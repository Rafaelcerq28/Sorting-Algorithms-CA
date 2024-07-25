import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class readVehiclesData {

    public static void main(String[] args) throws Exception {

        //Instanciating VehiclesLoader class
        VehiclesLoader loader = new VehiclesLoader();
        int dataSize = 100;


        //Loading the data into the arrays
        Sorting<Vehicles> vehiclesBSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<Vehicles> vehiclesQSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<String> toSearch = loader.loadColumData();

        // Checking if the data was loaded
        System.out.println("vehiclesBSorting size: "+ vehiclesBSorting.size());
        System.out.println("vehiclesQSorting size: " + vehiclesQSorting.size());
        System.out.println("toSearch size: " + toSearch.size());
        // Test to check if the data was sorted
        // System.out.println("Before sorting");
        // for(int i=0;i<vehiclesBSorting.size();i++){
        //     System.out.println(vehiclesBSorting.get(i));
        // }
        
        //variables to save start time, end time and execution time
        long startTime;
        long endTime;
        long executionTime; 

        System.out.println("\nQuick Sort:");
        startTime = System.currentTimeMillis();
        //running the sorting method
        vehiclesQSorting.quickSort(0, vehiclesQSorting.size() -1);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        System.out.println("\nbubble Sort:");
        startTime = System.currentTimeMillis();
        //running the sorting method
        vehiclesBSorting.simpleBubbleSort();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        // Test to check if the data was sorted
        // System.out.println("After sorting");
        // for(int i=0;i<vehiclesBSorting.size();i++){
        //     System.out.println(vehiclesBSorting.get(i));
        // }

        toSearch.sort(null);
        String elementToSearch = "";

        // toSearch.binarySearch(toSearch, "")

        if(toSearch.binarySearch(toSearch, elementToSearch) == -1){
           System.out.println(elementToSearch + " was not found in the toSearch list!"); 
        }else{
            System.out.println(elementToSearch + " was found in the toSearch list");
        }
        
    }
}