import java.util.Arrays;

// Return the third distinct maximum number in an array.
// If the third maximum does not exist, return the maximum number.

public class LeetCode_414 {
    public static void main(String[] args) {
        int[] arr = {6,4,3,4,1,2,4};
        // int[] arr = {6,4,4};
        // int[] arr = {5};
        System.out.println(thirdMax(arr));
    }

    static int thirdMax(int[] nums) {
        int result = 0;
        switch (nums.length) {
            case 1: {
                result = nums[0];
                break;
            }
            case 2: {
                result = Math.max(nums[0], nums[1]);
                break;
            }
            default: {
                Arrays.sort(nums); // sort ascending
                // System.out.println(Arrays.toString(nums));
                int count = 1;
                for (int i = nums.length-1; i >= 1; --i) {
                    if (nums[i] != nums[i-1]) {
                        ++count;
                    }
                    if (count == 3) {
                        result = nums[i-1];
                        break;
                    }
                }
                if (count == 1 || count == 2) { // ví dụ trường hợp nums = {2,2,2} hoặc {6,4,4}
                    result = nums[nums.length-1];
                }
                break;
            }
        }
        return result;
    }
}