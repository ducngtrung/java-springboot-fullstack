// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?

public class LeetCode_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    // Số cách leo bậc thang sẽ tăng dần theo dãy số Fibonacci
    static int climbStairs(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            default: {
                int arr[] = new int[n+1];
                arr[1] = 1;
                arr[2] = 2;
                for (int i = 3; i <= n; ++i) {
                    arr[i] = arr[i-1] + arr[i-2];
                }
                return arr[n];
            }  
        }
    }
}