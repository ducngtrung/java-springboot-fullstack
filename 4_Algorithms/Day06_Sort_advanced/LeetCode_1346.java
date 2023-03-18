// Given an array arr of integers, check if there exist two indices i and j such that :
// i != j
// 0 <= i,j < arr.length
// arr[i] == 2*arr[j]

public class LeetCode_1346 {
    public static void main(String[] args) {
        // int[] arr = {10,2,5,3};
        // int[] arr = {5,2,10,3};
        int[] arr = {3,7,0,11};
        System.out.println(checkIfExist(arr));
    }   

    static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                if ((arr[i] == arr[j]*2) && (i != j)) {
                    return true;
                }
            }
        }
        return false;
    }
}