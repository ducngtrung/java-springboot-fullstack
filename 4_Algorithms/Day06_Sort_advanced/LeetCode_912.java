import java.util.Arrays;

// Given an array of integers nums.
// Use merge sort or quick sort to sort the array in ascending order and return it.

public class LeetCode_912 {
    public static void main(String[] args) {
        // int[] nums = {5,2,3,1};
        int[] nums = {5,1,1,2,0,0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    static void sort(int[] arr, int iLeft, int iRight) {
        // Điều kiện dừng
        if (iLeft >= iRight) {
            return;
        }

        // Lấy phần tử ở giữa mảng làm key
        int iMid = (iLeft + iRight)/2;
        int key = arr[iMid];

        // Phân bố mảng:
        //      So sánh các phần tử với key và sắp xếp
        //      Lấy ra vị trí chốt để chia mảng
        int divider = partition(arr, iLeft, iRight, key);

        // Chia mảng ở vị trí chốt và tiếp tục phân bố trong nội bộ các mảng con
        sort(arr, iLeft, divider-1);
        sort(arr, divider, iRight);
    }

    static int partition(int[] arr, int iLeft, int iRight, int key) {
        int iL = iLeft;
        int iR = iRight;
        
        while (iL <= iR) {
            while (arr[iL] < key) {
                ++iL;
            }
            while (arr[iR] > key) {
                --iR;
            }
            // Đổi chỗ các phần tử không đúng vị trí
            if (iL <= iR) {
                int temp = arr[iL];
                arr[iL] = arr[iR];
                arr[iR] = temp;
                ++iL;
                --iR;
            }
        }
        return iL;
    }
}