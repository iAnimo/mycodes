package leets;

public class leet104 {
    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     */
    int combinationSum4(int[] nums, int target) {
        // step 1: dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // step 4: 先背包后物品 -- 排列
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[i] >= 0) { // 相加超过int的数据，所以需要在if里加上dp[i] < INT_MAX - dp[i - num]
                    // step 2: dp[i] += dp[i - nums[j]];
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
