package leets;

public class leet103 {
    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * 
     * 但本题和纯完全背包不一样，纯完全背包是能否凑成总金额，而本题是要求凑成总金额的个数！
     * 
     * 组合不强调元素之间的顺序，排列强调元素之间的顺序
     */

    int change(int amount, int[] coins) {
        // step 1: dp[j]：凑成总金额j的货币组合数为dp[j]
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // step 4: 先物品后容量是组合数;先容量后物品是排列数
        for (int i = 0; i < coins.length; i++) { // 物品
            for (int j = coins[i]; j <= amount; j++) { // 容量
                // step 2: 递推公式：dp[j] += dp[j - coins[i]];
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
