import java.util.Arrays;

// Given an integer array nums.
// Move all the even integers to the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

public class LeetCode_905 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4,5,0,8,6,7,9};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    static int[] sortArrayByParity(int[] nums) {
        int temp;
        for (int i = nums.length-1; i >= 0; --i) {
            if ((nums[i] % 2) != 0) { // Nếu nums[i] là số lẻ
                temp = nums[i];
                
                // Copy tất cả các phần tử (tính từ nums[i+1]) sang trái 1 vị trí
                for (int j = i+1; j < nums.length; ++j) {
                    nums[j-1] = nums[j];
                }
                
                // Gán phần tử cuối cùng của mảng = nums[i] (temp) 
                nums[nums.length-1] = temp;
            }
        }
        return nums;
    }
}