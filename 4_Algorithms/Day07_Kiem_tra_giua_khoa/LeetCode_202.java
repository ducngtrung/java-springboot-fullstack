import java.util.HashSet;
import java.util.Set;

// Write an algorithm to determine if a number n is happy.
// A happy number is a number defined by the following process:
//     Starting with any positive integer, replace the number by the sum of the squares of its digits.
//     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//     Those numbers for which this process ends in 1 are happy.

public class LeetCode_202 {
    public static void main(String[] args) {
        // int n = 19;
        int n = 2;
        System.out.println(isHappy(n));
    }

    static boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        return recursiveIsHappy(n, sumSet);
    }

    static boolean recursiveIsHappy(int n, Set<Integer> sumSet) {
        if (sumSet.contains(sumOfSquares(n))) {
            return false;
        } else {
            sumSet.add(sumOfSquares(n));
        }
        return (sumOfSquares(n) == 1) || recursiveIsHappy(sumOfSquares(n), sumSet);
    }

    // Calculate sum of the squares of the digits of integer n
    static int sumOfSquares(int n) {
        int result = 0;
        while (n != 0) {
            int digit = (int)(n % 10);
            result += Math.pow(digit, 2);
            n /= 10;
        }
        return result;
    }
}