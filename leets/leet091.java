package leets;

public class leet091 {
    /**
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯
     * 
     * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     * 
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    int minCostClimbingStairs(int[] cost) {
        // dp[i]的定义：第i个台阶所花费的最少体力为dp[i]。
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            // dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
        }

        return Math.min(dp[n - 1], dp[n - 2]); // 最后一步无需花费
    }
}
