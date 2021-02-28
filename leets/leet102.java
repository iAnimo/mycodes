package leets;

public class leet102 {
    /**
     * 完全背包
     */
    int[] weigth = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int bagWeigth = 4;

    int CompletePack() {
        int[] dp = new int[bagWeigth + 1];
        // 先遍历物品，在遍历背包
        for (int i = 0; i < weigth.length; i++) {
            for (int j = weigth[0]; j <= bagWeigth; j++) {
                dp[j] = Math.max(dp[j], dp[j - weigth[i]] + value[i]);
            }
        }

        return dp[bagWeigth];
    }
}
