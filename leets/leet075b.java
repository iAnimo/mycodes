package leets;

import java.util.Arrays;

public class leet075b {
    /**
     * 动态规划 - 时间复杂度O(n) 空间复杂度O(n)
     */
    int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        Arrays.fill(dp, 0);

        dp[0][0] -= prices[0];
        for (int i = 1; i < n; i++) {
            // 第i天持股票所剩最多现金 = max(第i-1天持股票所剩现金, 第i-1天持现金-买第i天的股票)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 第i天持有最多现金 = max(第i-1天持有的最多现金，第i-1天持有股票的最多现金+第i天卖出股票)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
