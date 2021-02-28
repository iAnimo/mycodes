package leets;

public class leet102b {
    int[] weigth = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeigth = 4;

    int CompletePack() {
        int[] dp = new int[bagWeigth + 1];
        // 先遍历背包，再遍历物品
        for (int j = weigth[0]; j <= bagWeigth; j++) {
            for (int i = 0; i < weigth.length; i++) {
                if (j - weigth[i] > 0) { // 边界
                    dp[j] = Math.max(dp[j], dp[j - weigth[i]] + value[i]);
                }
            }
        }

        return dp[bagWeigth];
    }
}
