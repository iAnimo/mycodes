package leets;

public class leet091b {
    /**
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    int minCostClimbingStairs(int[] cost) {
        // dp[i]的定义：第i个台阶所花费的最少体力为dp[i]。
        int dp0 = cost[0];
        int dp1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int dpi = Math.min(dp0, dp1 + cost[i]);
            dp0 = dp1;
            dp1 = dpi;
        }

        return Math.min(dp0, dp1);
    }
}
