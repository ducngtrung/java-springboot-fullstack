public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    // Tìm số thứ n trong dãy số Fibonacci: 1,1,2,3,5,8,13,...
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) { // Điều kiện dừng
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}