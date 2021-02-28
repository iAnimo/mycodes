package leets;

public class leet087 {
    /**
     * 本题相对于贪心算法：122.买卖股票的最佳时机II，多添加了一个条件就是手续费。
     */
    /**
     * 做收获利润操作的时候其实有三种情况：
     * 
     * 情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），所以后面要继续收获利润。
     * 
     * 情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），今天要重新记录最小价格了。
     * 
     * 情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
     */
    int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {

            // case 2 卖出
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // case 1 买入
            if (prices[i] > minPrice + fee) {
                result += prices[i] - (minPrice+fee);
                minPrice = prices[i] - fee; // 去掉之前买入时的费用
            }
        }

        return result;
    }     
}
