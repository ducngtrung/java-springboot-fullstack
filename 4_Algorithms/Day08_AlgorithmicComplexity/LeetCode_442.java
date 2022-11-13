import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an integer array nums of length n.
// All the integers of nums are in the range [1, n].
// Each integer appears once or twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant extra space.

public class LeetCode_442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        
        // Sắp xếp mảng tăng dần 
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; ++i) {
            if (nums[i] == nums[i+1]) {
                resultList.add(nums[i]);
                ++i; // Vì đang có 2 số giống nhau nằm cạnh nhau nên tăng i để skip số trùng lặp
            }
        }
        return resultList;
    }
}