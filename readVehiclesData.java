public class readVehiclesData {

    public static void main(String[] args) throws Exception {

        //Instanciating VehiclesLoader class
        VehiclesLoader loader = new VehiclesLoader();
        int dataSize = 100;


        //Loading the data into the arrays
        Sorting<Vehicles> vehiclesBSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<Vehicles> vehiclesQSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        
        // Checking if the data was loaded
        System.out.println("vehiclesBSorting size: "+ vehiclesBSorting.size());
        System.out.println("vehiclesQSorting size: " + vehiclesQSorting.size());

        System.out.println("Before sorting");
        for(int i=0;i<vehiclesBSorting.size();i++){
            System.out.println(vehiclesBSorting.get(i));
        }
        
        //variables to save start time, end time and execution time
        long startTime;
        long endTime;
        long executionTime; 

        // System.out.println("\nQuick Sort:");
        // startTime = System.currentTimeMillis();
        // //running the sorting method
        // vehiclesQSorting.quickSort(0, vehiclesQSorting.size() -1);
        // endTime = System.currentTimeMillis();
        // executionTime = endTime - startTime;
        // System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        // System.out.println();

        System.out.println("\bubble Sort:");
        startTime = System.currentTimeMillis();
        //running the sorting method    
        vehiclesBSorting.simpleBubbleSort();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        System.out.println("After sorting");
        for(int i=0;i<vehiclesBSorting.size();i++){
            System.out.println(vehiclesBSorting.get(i));
        }

        //Value I want to search
        long valueToSearch = 1000;

        //Object used to search by the value in the list
        Vehicles vehicleToSearch = new Vehicles(932, 
                                "Fusca", 
                                "Diesel",
                                "Tennessee", 
                                123123, 
                                valueToSearch);

        System.out.println("Searching for value: "+valueToSearch +"\n"+vehiclesBSorting.binarySearch(vehicleToSearch, 0, vehiclesBSorting.size() -1));

        //Testing with a different value
        valueToSearch = 1001;
        vehicleToSearch.setlValue(valueToSearch);
        System.out.println("Searching for value: "+valueToSearch +"\n"+vehiclesBSorting.binarySearch(vehicleToSearch, 0, vehiclesBSorting.size() -1));

    }
}