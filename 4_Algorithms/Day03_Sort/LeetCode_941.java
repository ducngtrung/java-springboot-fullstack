// Given an array of integers arr, return true if and only if it is a valid mountain array.

public class LeetCode_941 {
    public static void main(String[] args) {
        int[] arr = {0,2,3,4,5,2,1};
        // int[] arr = {0,2,4,3,5,2,1,0};
        // int[] arr = {0,1,2,3,4,5,6,7};
        System.out.println(validMountainArray(arr));
    }

    static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        
        // Walk up to find the peak index
        while ((i < n-1) && (arr[i] < arr[i+1])) {
            ++i;
        }

        // Peak can't be first or last
        if ((i == 0) || (i == n-1)) {
            return false;
        }

        // Walk down to reach the last index
        while ((i < n-1) && (arr[i] > arr[i+1])) {
            ++i;
        }
        return (i == n-1);
    }
}