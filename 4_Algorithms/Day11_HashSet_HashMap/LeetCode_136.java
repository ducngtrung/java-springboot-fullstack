import java.util.HashSet;
import java.util.Set;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

public class LeetCode_136 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (Integer num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
            } else {
                hashSet.remove(num);
            }
        }
        return hashSet.hashCode();
        // hoặc return hashSet.iterator().next();
    }
}