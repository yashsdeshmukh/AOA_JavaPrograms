package aoaPrograms;

public class MinMax {

	static class Pair {
        int min;
        int max;
    }
 
    static Pair getMinMax(int arr[], int low, int high) {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        int mid;
 
        // If there is only one element
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            //return directly to the caller
            return minmax;
        }
 
        // If there are two elements 
        if (high == low + 1) {
        	//setting the min and max
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            //return directly to the caller
            return minmax;
        }
 
        ///If there are more than 2 elements
        mid = (low + high) / 2;
        //recursive call to the function and hence divide and conquer
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid + 1, high);
 
        //compare minimums of two parts
        if (mml.min < mmr.min) {
            minmax.min = mml.min;
        } else {
            minmax.min = mmr.min;
        }
 
        //compare maximums of two parts
        if (mml.max > mmr.max) {
            minmax.max = mml.max;
        } else {
            minmax.max = mmr.max;
        }
 
        return minmax;
    }
 
    public static void main(String args[]) {
        int arr[] = {2, 5, 6, 1, 6, 3};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
 
    }

}
