public class Factorial {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(factorial(5));
        long endTime = System.nanoTime();
        System.out.println("Thời gian chạy: " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.println(factorialRecursion(5));
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy đệ quy: " + (endTime - startTime));
    }

    // Tính giai thừa (KHÔNG dùng đệ quy)
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; ++i) {
            result *= i;
        }
        return result;
    }

    // Tính giai thừa (dùng đệ quy)
    public static long factorialRecursion(int n) {
        if (n == 0) { // Điều kiện dừng
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}