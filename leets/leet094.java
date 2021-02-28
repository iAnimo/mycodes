package leets;

public class leet094 {
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积。
     */
    int integerBreak(int n) {
        
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }

        return dp[n];
    }
}
