import java.lang.reflect.Method;
import java.util.*;

public class Sorting <ElementType> extends ArrayList<ElementType>{
    
    /* QUICK SORT */
    public void quickSort(int start, int end) {
        int pivotIndex;
        if (start < end) {
            /*
                select pivot and re-arrange elements in two partitions such as
                all array[start … p-1] are less than pivot = array [p] and
                all array[p+1 … end] are >= pivot
             */
            pivotIndex = partition(start, end);

            // sort first partition of the array (from start to pivot_index-1)
            quickSort(start, pivotIndex - 1);

            //sort second partition of the array
            quickSort(pivotIndex + 1, end);
        } else // do nothing, the array has one element, so it is sorted
        {
            return;
        }
    }

    public int partition(int start, int end) {
        int up, down;
        ElementType pivot;

        // select the first element as pivot
        pivot = get(start);

        // set the UP and DOWN indexes
        up = start;
        down = end;

        // as long as UP and DOWN indexes did not pass each other
        while (up < down) {
            // increment UP index until found first element higher than pivot
            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) <= 0) {
                up = up + 1;
            }

            // decrement DOWN until found first element smaller than  pivot
            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) > 0)) {
                down = down - 1;
            }

            // if UP and DOWN indexes did not pass each other
            if (up < down) {
                ElementType elementUp = get(up);
                //swap the two elements found
                set(up, get(down));
                set(down, elementUp);
            }
        }

        // UP and DOWN indexes have passed each other, so swap pivot with the element on DOWN position
        set(start, get(down));
        set(down, pivot);
        return down;
    }

    /* BUBBLE SORT */
    public void simpleBubbleSort() {
        boolean moreSwaps = true;

        while (moreSwaps == true) {
            int count;
            moreSwaps = false;
            for (count = 0; count < size() - 1; count++) {
                Comparable elementAtiCount = (Comparable) get(count);
                Comparable elementAtiCountPlus = (Comparable) get(count + 1);

                if (elementAtiCount.compareTo(elementAtiCountPlus) > 0) {
                    swap(count, count + 1);
                    moreSwaps = true;
                }
            }
        }
    }
    
    public void swap(int inPos1, int inPos2) {
        //Create two objects that will store the info from the two positions
        ElementType objPos1 = get(inPos1);
        ElementType objPos2 = get(inPos2);

        //Remove element from position 1
        remove(inPos1);

        //Insert objPos2 into position 1
        add(inPos1, objPos2);

        //Remove element from position 2
        remove(inPos2);

        // Insert objPos1 into position 2
        add(inPos2, objPos1);
    }

    public static int binarySearch(ArrayList<String> arr, String value) {
        int left = 0;
        int right = arr.size() - 1;
        // int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            String midValue = arr.get(mid);

            int cmp = midValue.compareTo(value);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Valor não encontrado
    }

}






