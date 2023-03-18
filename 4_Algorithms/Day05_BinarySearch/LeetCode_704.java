import java.util.Arrays;

// Given an array of integers "nums" which is sorted in ascending order, and an integer "target".
// Write a function to search target in "nums".
// If "target" exists, then return its index. Otherwise, return -1.

public class LeetCode_704 {
    public static void main(String[] args) {
        int[] arr = {3,4,6,7,9,11,14};
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(arr, 9, 0, arr.length-1));
        System.out.println(Arrays.binarySearch(arr, 9));
    }

    // Cài đặt tìm kiếm nhị phân (binary search) bằng vòng lặp
    static int binarySearch(int[] nums, int target) {
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
        return -1;
    }

    // Cài đặt binary search bằng đệ quy
    static int binarySearch(int[] nums, int target, int iLeft, int iRight) {
        if (iLeft > iRight) {
            return -1;
        }
        int iMid = (iLeft + iRight)/2;
        if (nums[iMid] == target) {
            return iMid;
        } else if (nums[iMid] < target) {
            return binarySearch(nums, target, iMid+1, iRight);
        } else {
            return binarySearch(nums, target, iLeft, iMid-1);
        }
    }
}