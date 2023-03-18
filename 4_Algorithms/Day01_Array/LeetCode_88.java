import java.util.Arrays;

// Given 2 integer arrays nums1 and nums2, sorted in non-decreasing order
// 2 integers m and n representing the number of elements in nums1 and nums2 respectively
// Merge nums1 and nums2 into a single array sorted in non-decreasing order

public class LeetCode_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int temp;
        for (int i = m; i < nums1.length; ++i) {
            nums1[i] = nums2[j];
            
            // sort ascending
            for (int k = 0; k < i; ++k) {
                if (nums1[k] > nums1[i]) {
                    temp = nums1[k];
                    nums1[k] = nums1[i];
                    nums1[i] = temp;
                }
            }
            
            ++j;
        }

        // // Cách 2:
        // System.arraycopy(nums2, 0, nums1, m, n);
        // Arrays.sort(nums1);
        // // Hoặc: Array.sortAscending(nums1);

        // // Cách 3:
        // int i = m-1;
        // int j = n-1;
        // int k = (m+n)-1;
        // while (k >= 0) {
        //     if (i < 0) { // Mảng nums1 không có phần tử
        //         nums1[k] = nums2[j];
        //         --j;
        //     } else if (j < 0) { // Mảng nums2 không có phần tử
        //         nums1[k] = nums1[i];
        //         --i;
        //     } else if (nums1[i] < nums2[j]) {
        //         nums1[k] = nums2[j];
        //         --j;
        //     } else { // (nums1[i] >= nums2[j])
        //         nums1[k] = nums1[i];
        //         --i;
        //     }
        //     --k;
        // }
    }
}