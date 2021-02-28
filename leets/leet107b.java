package leets;

import java.util.Arrays;

public class leet107b {
    int numSquares(int n) {
        // step 1: dp[i]：和为i的完全平方数的最少数量为dp[i]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // step 4: 无顺序
        for (int j = 1; j * j <= n; j++) { // 物品 j*j
            for (int i = 1; i <= n; i++) { // 背包 1-n
                // step 2: dp[j] = min(dp[j - i * i] + 1, dp[j]);
                if (i - j * j >= 0 && dp[i - j * j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }

        return dp[n];
    }
}
