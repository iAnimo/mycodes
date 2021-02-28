package leets;

public class leet094b {
    /**
     * 
     * 贪心的解法
     * 
     * 这个代码也可以AC，大体上一看好像也没有毛病，递推公式也说得过去，但是仅仅是恰巧过了而已。
     */
    int integerBreak(int n) {
        if (n < 3) {
            return 1 * (n - 1);
        }
        int[] dp = new int[n + 1];
        // 递推公式没毛病，但初始化解释不通！
        dp[1] = 1;
        dp[2] = 2; // 根据dp[i]的定义，dp[2]也不应该是2啊。
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }

        return dp[n];
    }
}
