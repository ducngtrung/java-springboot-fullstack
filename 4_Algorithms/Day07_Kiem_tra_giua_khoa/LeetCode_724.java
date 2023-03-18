// Given an array of integers nums, calculate the pivot index of this array.
// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
// If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
// Return the leftmost pivot index. If no such index exists, return -1

public class LeetCode_724 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        // int[] nums = {1,2,3};
        // int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }

    static int pivotIndex(int[] nums) {
        if (calculateSum(nums, 1, nums.length-1) == 0) return 0;
        
        int pivot = 1;
        while (pivot <= nums.length-2) {
            if (calculateSum(nums, 0, pivot-1) == calculateSum(nums, pivot+1, nums.length-1)) {
                return pivot;
            }
            ++pivot;
        }

        if (calculateSum(nums, 0, nums.length-2) == 0) return nums.length-1;
        
        return -1;
    }

    static int calculateSum(int[] nums, int iR, int iL) {
        int sum = 0;
        for (int i = iR; i <= iL; ++i) {
            sum += nums[i];
        }
        return sum;
    }
}