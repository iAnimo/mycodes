package leets;

import java.util.Arrays;

public class leet106 {
    /**
     * 给定不同面额的硬币 coins 和一个总金额
     * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 
     * 你可以认为每种硬币的数量是无限的。
     */
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // step 1:dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // step 4:无先后之分
        for (int i = 0; i < coins.length; i++) { // 物品
            for (int j = coins[i]; j <= amount; j++) { // 背包
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    // step 2:递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
