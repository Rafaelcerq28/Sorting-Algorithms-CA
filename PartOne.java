import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartOne {

    public static void main(String[] args) throws Exception {

        //Instanciating VehiclesLoader class
        VehiclesLoader loader = new VehiclesLoader();
        int dataSize = 2000;


        //Loading the data into the arrays for bubble sort, quick sort and binary search
        Sorting<Vehicles> vehiclesBSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<Vehicles> vehiclesQSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<String> toSearch = loader.loadColumData();

        //Checking if the data was loaded
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

        //Code to run the quick sort method
        System.out.println("\nQuick Sort:");
        //save the miliseconds into the start time
        startTime = System.currentTimeMillis();
        //running the sorting method
        vehiclesQSorting.quickSort(0, vehiclesQSorting.size() -1);
        //after the quickSort runs I store the miliseconds into the endTime
        endTime = System.currentTimeMillis();
        //using endTime and startTime to get the execution time
        executionTime = endTime - startTime;
        //printing the values
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        //Code to run the bubble sort method
        System.out.println("\nbubble Sort:");
        //save the miliseconds into the start time
        startTime = System.currentTimeMillis();
        //running the sorting method
        vehiclesBSorting.simpleBubbleSort();
        //after the quickSort runs I store the miliseconds into the endTime
        endTime = System.currentTimeMillis();
        //using endTime and startTime to get the execution time
        executionTime = endTime - startTime;
         //printing the values
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        // Test to check if the data was sorted
        // System.out.println("After sorting");
        // for(int i=0;i<vehiclesBSorting.size();i++){
        //     System.out.println(vehiclesBSorting.get(i));
        // }

        //Using the method sort to sort arrayList
        toSearch.sort(null);

        //Saving a location to search
        String elementToSearch = "Colorado";

        //using the binarySearch method to search for my data 
        if(toSearch.binarySearch(toSearch, elementToSearch) == -1){
            //message if the value was not found 
           System.out.println(elementToSearch + " was NOT FOUND in the vehicles list!"); 
        }else{
            //message if the value was found
            System.out.println(elementToSearch + " was FOUND in the vehicles list");
        }
        
    }
}