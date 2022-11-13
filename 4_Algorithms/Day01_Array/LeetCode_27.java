import java.util.Arrays;

// Remove all occurrences of val from the array nums and return the number of elements left

public class LeetCode_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    static int removeElement(int[] nums, int val) {
        int temp;
        int count = 0;

        // Move all elements that are not equal to val to the beginning of the array
        for (int i = 0; i < nums.length; ++i) {
            temp = nums[i];
            if (temp != val) {
                nums[count++] = temp;
            }
        }

        // Set the elements at the end of the array to be 0
        for (int i = count; i < nums.length; ++i) {
            nums[i] = 0;
        }

        return count;
    }
}