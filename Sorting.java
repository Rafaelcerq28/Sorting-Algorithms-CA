import java.lang.reflect.Method;
import java.util.*;

public class Sorting <ElementType> extends ArrayList<ElementType>{
    
    /* QUICK SORT */
    public void quickSort(int start, int end) {
        int pivotIndex;
        // Check if the sublist has more than one element
        if (start < end) {
            // Partition the list and get the pivot index
            pivotIndex = partition(start, end);
            // using recursion sort the sublist to the left of the pivot
            quickSort(start, pivotIndex - 1);
            // using recursion sort the sublist to the right of the pivot
            quickSort(pivotIndex + 1, end);
        } else{
            //if the sublist has 0 or 1 element, there is nothing to sort
            return;
        }
    }
    /* Method to partition the list */
    public int partition(int start, int end) {
        int up, down;
        ElementType pivot;
        // Select the first element as the pivot
        pivot = get(start);

        up = start;
        down = end;
        // Continue partitioning while the up and down indices do not cross
        while (up < down) {
            // Move the up index to the right until finding an element greater than the pivot
            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) <= 0) {
                up = up + 1;
            }
            // Move the down index to the left until finding an element less than or equal to the pivot
            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) > 0)) {
                down = down - 1;
            }

            // If the up and down indices have not crossed, swap the elements
            if (up < down) {
                ElementType elementUp = get(up);
                set(up, get(down));
                set(down, elementUp);
            }
        }
        // Place the pivot in its correct position between the smaller and larger element
        set(start, get(down));
        set(down, pivot);
        // Return the final index of the pivot
        return down;
    }

    /* BUBBLE SORT */
    public void simpleBubbleSort() {
        //variable to store if I need swaps
        boolean moreSwaps = true;

        // Continue looping until no more swaps are needed
        while (moreSwaps == true) {
            int count;
            moreSwaps = false;

            // Iterate over the list, comparing adjacent elements
            for (count = 0; count < size() - 1; count++) {
                Comparable elementAtiCount = (Comparable) get(count);
                Comparable elementAtiCountPlus = (Comparable) get(count + 1);

                // If the current element is greater than the next element, swap them
                if (elementAtiCount.compareTo(elementAtiCountPlus) > 0) {
                    swap(count, count + 1);
                    // Indicate that a swap has occurred
                    moreSwaps = true;
                }
            }
        }
    }
    
    public void swap(int inPos1, int inPos2) {
        // Create two objects that will store the info from the two positions
        ElementType objPos1 = get(inPos1);
        ElementType objPos2 = get(inPos2);

        //Remove element from position 1
        remove(inPos1);

        //Insert object from position 2 into position 1
        add(inPos1, objPos2);

        //Remove element from position 2
        remove(inPos2);

        // Insert object from position 1 into position 2
        add(inPos2, objPos1);
    }

    public static int binarySearch(ArrayList<String> arr, String value) {
        // Initialize the left variable
        int left = 0;
        // Initialize the right variable
        int right = arr.size() - 1;

        // Continue searching while the left boundary is less than or equal to the right boundary
        while (left <= right) {
            // Calculate the middle index of the current search range
            int mid = (left + right) / 2;
            // Get the value at the middle index
            String midValue = arr.get(mid);

            // Compare the middle value to the target value
            int cmp = midValue.compareTo(value);
            if (cmp == 0) {
                // Target value found at the middle index, return the index
                return mid;
            } else if (cmp < 0) {
                // Target value is greater than the middle value, search in the right half
                left = mid + 1;
            } else {
                // Target value is less than the middle value, search in the left half
                right = mid - 1;
            }
        }
        // Target value not found, return -1
        return -1;
    }

}






