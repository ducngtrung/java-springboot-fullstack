// Find how many numbers having even number of digits

public class LeetCode_1295 {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; ++i) {
            String string = Integer.toString(nums[i]);
            // Hoặc: String string = String.valueOf(nums[i]);
            if ((string.length() % 2) == 0) {
                ++count;
            }
        }
        return count;

        // // Cách 2:
        // int count = 0;
        // for (int i : nums) {
        //     if ((countDigit(i) % 2) == 0) {
        //         ++count;
        //     }
        // }
        // return count;
    }
    
    // static int countDigit(int number) {
    //     int count = 0;
    //     while (number != 0) {
    //         number = number/10;
    //         ++count;
    //     }
    //     return count;
    // }
}