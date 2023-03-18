// Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the 32-bit integer range [-231, 231 - 1], then return 0.

public class LeetCode_7 {
    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }

    static int reverse(int x) {
        int reverse = 0, lastReverse = 0;
        boolean isNegative = (x < 0);

        if (isNegative) { // chuyển số âm sang số dương
            x = x * -1;
        }

        // Đảo các chữ số số
        while (x > 0) {
            lastReverse = reverse;
            reverse = reverse * 10 + x % 10;
            x /= 10;
            if (lastReverse > reverse/10) {
                return 0;
            }
        }

        if (isNegative) { // chuyển số dương sang số âm
            return reverse * -1;
        } else {
            return reverse;
        }
    }
}