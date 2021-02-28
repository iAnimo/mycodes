package leets;

public class leet092c {
    /**
     * 优化空间
     */
    int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i] += dp[i - 1];
            }
        }

        return dp[n - 1];
    }
}
