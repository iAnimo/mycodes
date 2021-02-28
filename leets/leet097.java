package leets;

public class leet097 {
    /**
     * 一维dp数组（滚动数组）
     * 
     * 递推公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
     * 
     * 其实可以发现如果把dp[i - 1]那一层拷贝到dp[i]上，表达式完全可以是：dp[i][j] = max(dp[i][j], dp[i][j-weight[i]] + value[i]);
     * 
     * 于其把dp[i - 1]这一层拷贝到dp[i]上，不如只用一个一维数组了，只用dp[j]（一维数组，也可以理解是一个滚动数组）。
     * 
     * 一维dp数组的背包在遍历顺序上和二维其实是有很大差异
     */
    int[] weight = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeight = 4;

    int maxValue() {
        int m = weight.length;
        int n = bagWeight;

        int[] dp = new int[n+1];

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= weight[i]; j--) {  // 需要使用倒序遍历
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }

        return dp[n];
    }
    /* 物品
        0：0 15 15 15 15 - 初始
        1：0 15 15 20 35
        2：0 15 15 20 35 
    */
}
