package leets;

import java.util.Arrays;

public class leet107 {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 
     * 背包：完全平方数就是物品（可以无限件使用），凑个正整数n就是背包，问凑满这个背包最少有多少物品？
     */
    int numSquares(int n) {
        // step 1: dp[i]：和为i的完全平方数的最少数量为dp[i]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // step 4: 无顺序
        for (int i = 0; i <= n; i++) { // 背包 0-n
            for (int j = 1; j * j <= n; j++) { // 物品 j*j
                // step 2: dp[j] = min(dp[j - i * i] + 1, dp[j]);
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
