import java.util.Arrays;

// Given a fixed-length integer array arr.
// Duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note:
//     Elements beyond the length of the original array are not written.
//     Do the  modifications to the input array in place.

public class LeetCode_1089 {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void duplicateZeros(int[] arr) {
        int[] cloneArr = new int[arr.length];

        // Create a clone array with duplicate zeros
        for (int i=0, j=0; i<arr.length && j<arr.length; ++i, ++j) {
            if (arr[i] == 0) {
                cloneArr[j] = arr[i];
                ++j;
            }
            if (j >= arr.length) {
                break;
            }
            cloneArr[j] = arr[i];
        }

        // Copy all elements from the clone array to the original array
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = cloneArr[i];
        }

        // // Cách 2:
        // System.out.println(Arrays.toString(arr));
        // for (int i = 0; i < arr.length-1; ++i) {
        //     if (arr[i] == 0) { // Nếu arr[i]=0 thì copy tất cả các phần tử (tính từ arr[i]) sang phải 1 vị trí
        //         for (int j = arr.length-1; j > i; --j) {
        //             arr[j] = arr[j-1];
        //         }
        //         ++i;
        //     }
        // }
    }
}