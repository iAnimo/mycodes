package leets;

public class leet109 {
    /**
     * 多重背包
     * 
     * 有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
     * 
     * 时间复杂度：O(m * n * k)  m：物品种类个数，n背包容量，k单类物品数量
     */
    int[] weigth = { 1, 3, 4 };
    int[] value = { 15, 20, 30 };
    int[] nums = { 2, 3, 2 };
    int bagWeigth = 10;
    int multiPack() {
        // 摊开
        int ws = weigth.length;
        int vs = value.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 1) {
                weigth[ws++] = weigth[i];
                value[vs++] = value[i];
                nums[i] --;
            }
        }

        int[] dp = new int[bagWeigth + 1];
        for (int i = 0; i < ws; i++) {
            for (int j = bagWeigth; j >= weigth[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weigth[i]] + value[i]);
            }
        }

        return dp[bagWeigth];
    }
}
