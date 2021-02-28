package leets;

public class leet109b {
    /**
     * 另一种实现方式，就是把每种商品遍历的个数放在01背包里面在遍历一遍。
     */
    int[] weigth = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int[] nums = { 2, 3, 2 };
    int bagWeigth = 10;

    int multiPack() {
        int[] dp = new int[bagWeigth + 1];
        for (int i = 0; i < weigth.length; i++) { // 物品
            for (int j = bagWeigth; j >= weigth[i]; j--) { // 背包
                for (int k = 1; k <= nums[i] && (j - k * weigth[i]) >= 0; k++) {    // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weigth[i]] + k * value[i]);
                }
            }
        }

        return dp[bagWeigth];
    }
}
