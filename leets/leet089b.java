package leets;

public class leet089b {

    // 时间复杂度：O(n) 空间复杂度：O(1)
    int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }
}