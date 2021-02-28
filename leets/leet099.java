package leets;

public class leet099 {
    /**
     * 最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
     * 
     * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
     */
    int lastStoneWeightII(int[] stones) {
        // dp[j]表示容量（这里说容量更形象，其实就是重量）为j的背包，最多可以背dp[j]这么重的石头。
        int[] dp = new int[15001];

        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return (sum - dp[target]) - dp[target]; // 两堆石块碰撞后的最小值
    }

}
