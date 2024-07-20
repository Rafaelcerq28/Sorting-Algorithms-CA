public class readVehiclesData {

    public static void main(String[] args) throws Exception {

        //Instanciating VehiclesLoader class
        VehiclesLoader loader = new VehiclesLoader();
        int dataSize = 100;


        //Loading the data into the arrays
        Sorting<Vehicles> vehiclesBSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        Sorting<Vehicles> vehiclesQSorting = (Sorting<Vehicles>) loader.loadData(dataSize);
        
        // Checking if the data was loaded
        System.out.println(vehiclesBSorting.size());
        System.out.println(vehiclesQSorting.size());

        // System.out.println("Before sorting");
        // for(int i=0;i<vehiclesQSorting.size();i++){
        //     System.out.println(vehiclesQSorting.get(i));
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

        System.out.println("\bubble Sort:");
        startTime = System.currentTimeMillis();
        //running the sorting method    
        vehiclesBSorting.simpleBubbleSort();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();


        // System.out.println("After sorting");
        // for(int i=0;i<vehiclesQSorting.size();i++){
        //     System.out.println(vehiclesQSorting.get(i));
        // }

    }

}

