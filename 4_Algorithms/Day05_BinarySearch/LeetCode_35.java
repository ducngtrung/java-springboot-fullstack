// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

public class LeetCode_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 6));
        System.out.println(searchBinaryInsert(nums, 4));
    }

    static int searchInsert(int[] nums, int target) {
        int count = 0;
        while (count < nums.length) {
            if (nums[count] >= target)
                return count;
            ++count;
        }
        return count;
    }

    // Cách 2: áp dụng Binary Search
    static int searchBinaryInsert(int[] nums, int target) {
        int iLeft = 0;
        int iRight = nums.length-1;
        while (iLeft <= iRight) {
            int iMid = (iLeft + iRight)/2;
            if (nums[iMid] == target) {
                return iMid;
            } else if (nums[iMid] < target) {
                iLeft = iMid + 1;
            } else {
                iRight = iMid - 1;
            }
        }
        return iLeft;
    }
}