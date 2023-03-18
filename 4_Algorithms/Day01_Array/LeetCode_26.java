import java.util.Arrays;

// Remove duplicates from a sorted array and return the number of unique elements

public class LeetCode_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    static int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int count = 1;

        // Move all unique elements to the beginning of the array
        for (int i = 0; i < nums.length; ++i) {
            if (temp != nums[i]) {
                temp = nums[i];
                nums[count++] = temp;
            }
        }

        // Set the duplicates elements (at the end of the array) to be 0
        for (int i = count; i < nums.length; ++i) {
            nums[i] = 0;
        }

        return count;
    }
}