package leets;

public class leet075 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     */
    // 其实我们需要收集每天的正利润就可以
    // 贪心算法 - 时间复杂度O(n) 空间复杂度O(1)
    int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i-1], 0);
        }

        return result;
    }
}
