// Given an array of integers nums, return the number of good pairs.
// A pair (i, j) is called good if nums[i] == nums[j] and i < j.

public class LeetCode_1512 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        // int[] nums = {1,1,1,1};
        // int[] nums = {1,2,3};
        System.out.println(numIdenticalPairs(nums));
    }

    static int numIdenticalPairs(int[] nums) {
        int startIndex = 0;
        int count = 0;
        while (startIndex < nums.length-1) {
            for (int i = startIndex+1; i <= nums.length-1; ++i) {
                if (nums[i] == nums[startIndex]) {
                    ++count;
                }
            }
            ++startIndex;
        }
        return count;
    }
}