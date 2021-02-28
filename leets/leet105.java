package leets;

public class leet105 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 
     * 每次你可以爬 1 或 2 个 、m 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    int climbStairs(int n, int m) {
        // step 1: dp[i]：爬到有i个台阶的楼顶，有dp[i]种方法
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // step 4: 排列 - 先背包后物品
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) {
                    // step 2: dp[i] += dp[i - j]
                    dp[i] += dp[i - j];
                }
            }
        }

        return dp[n];
    }
}
