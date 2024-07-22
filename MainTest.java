public class MainTest {

    public static int binarySearch(int [] list, int toFind){

        boolean found = false;
        int left = 0;
        int right = list.length-1;
        int mid = 0;
        int midValue = 0;

        while ((left <= right) && (found == false)) {
            
            mid = (left + right) / 2;
            midValue = list[mid];

            if(midValue == toFind){
                found = true;
            }else if (midValue < toFind) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }    

        if (found == true) {
            return mid;
        }else{
            return -1;
        }
        
    }

    public static void main(String[] args) {
        
        int [] list = {2,6,8,9,15,19,25,33,44,58,65,100};
        
        System.out.println(binarySearch(list, 2));

    }
}
