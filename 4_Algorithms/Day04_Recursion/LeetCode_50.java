// Implement pow(x, n), which calculates x raised to the power n

public class LeetCode_50 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(myPow(3, -2));       
        long endTime = System.nanoTime();
        System.out.println("Thời gian chạy đệ quy: " + (endTime - startTime));
    }

    // Sử dụng đệ quy
    static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x*x;
        if (n < 0) return (1/x) * myPow(1/x, -(n+1));
        if (n % 2 == 0) {
            return myPow(myPow(x, n/2), 2);
        } else {
            return x * myPow(myPow(x, n/2), 2);
        }
    }
}