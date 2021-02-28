package leets;

import java.util.Vector;

public class leet100b {
    /**
     * 动态规划
     * 
     * step 1 : dp[j] 表示：填满j（包括j）这么大容积的包，有dp[i]种方法 step 2 : 把 这些方法累加起来就可以了，dp[i] +=
     * dp[j - nums[j]] step 4: nums放在外循环，target在内循环，且内循环倒序。
     */
    int findTargetSumWays(Vector<Integer> nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        if (s > sum) {
            return 0;
        }
        if ((s + sum) % 2 == 1) {
            return 0;
        }
        
        int bagSize = (s + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = bagSize; j >= nums.get(i); j--) {
                dp[j] += dp[j - nums.get(i)];
            }
        }

        return dp[bagSize];
    }
}
