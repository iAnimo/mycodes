package leets;

public class leet101 {
    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     */
    int findMaxForm(String[] strs, int m, int n) {
        // step 1: dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int one = 0;
            int zero = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            // step 4: 外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！:物品就是strs里的字符串，背包容量就是题目描述中的m和n。
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    // step 2: 递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
