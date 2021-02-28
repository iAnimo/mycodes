package leets;

import java.util.Arrays;

public class leet106b {
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // step 1:dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // step 4:无先后之分
        for (int j = 1; j <= amount; j++) { // 背包
            for (int i = 0; i < coins.length; i++) { // 物品
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
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
