package leets;

public class leet090b {
    /**
     * 两个状态
     * 
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return dp[2];
    }
}
