package leets;

public class leet096 {
    /**
     * 01 背包问题
     */
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;

    int maxValue() {
        int m = weight.length;
        int n = bagWeight;
        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int[][] dp = new int[m + 1][n + 1];
        for (int j = n; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < weight[i]) {
                    // 递归公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i] );
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[m][n];
    }
    
    // 遍历过程
    /* 
    for(int i = 1; i < weight.size(); i++) { // 遍历物品
        for(int j = 0; j <= bagWeight; j++) { // 遍历背包容量
            if (j - weight[i] >= 0) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
    } */
}
