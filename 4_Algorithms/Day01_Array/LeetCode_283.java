import java.util.Arrays;

// Given an integer array nums.
// Move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = {1,3,12,0,6,0,8,0,9}; 
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        for (int i = nums.length-1; i >= 0; --i) {
            if (nums[i] == 0) {
                // Copy tất cả các phần tử (tính từ nums[i+1]) sang trái 1 vị trí
                for (int j = i+1; j < nums.length; ++j) {
                    nums[j-1] = nums[j];
                }
                // Gán phần tử cuối cùng của mảng = 0 
                nums[nums.length-1] = 0;
            }
        }

        // // Cách 2 (chỉ dùng 1 vòng lặp):
        // int temp;
        // int j = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] != 0) {
        //         temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         ++j; // j dùng để lưu index của phần tử 0 đầu tiên trong mảng
        //     }
        // }
    }
}