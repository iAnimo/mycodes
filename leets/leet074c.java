package leets;

public class leet074c {
    // 动态规划 - 时间复杂度：O(n) 空间复杂度：O(n)
    int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }
}
