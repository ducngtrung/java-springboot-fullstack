// You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
// A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

public class LeetCode_1672 {
    public static void main(String[] args) {
        int[][] accounts = {
            {2,8,7},
            {7,1,3},
            {1,9,5},
        };
        
        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts) {
        int maxRowSum = 0;
        for (int i = 0; i < accounts.length; ++i) {
            int rowSum = 0;
            for (int j = 0; j < accounts[0].length; ++j){
                rowSum += accounts[i][j];
            }
            maxRowSum = Math.max(rowSum, maxRowSum);
        }
        return maxRowSum;
    }
}