import java.util.Stack;

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?

public class LeetCode_70_2 {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    // Số cách leo bậc thang sẽ tăng dần theo dãy số Fibonacci
    static int climbStairs(int n) {
        Stack<Integer> stack = new Stack<Integer>();

        if (n < 3) {
            return n;
        }

        stack.push(0);
        stack.push(1);
        stack.push(2);

        for (int i = 3; i <= n; ++i) {
            int d1 = stack.pop();
            int d2 = stack.pop();

            int d3 = d1 + d2; // Quy tắc của dãy số Fibonacci

            stack.push(d2);
            stack.push(d1);
            stack.push(d3);
        }
        return stack.peek();
    }
}