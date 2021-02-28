package leets;

public class leet087b {
    /**
     * 动态规划
     * 
     * 只需要在计算卖出操作的时候减去手续费就可以了，代码几乎是一样的。
     */
    int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        // dp[i][1]第i天持有的最多现金
        // dp[i][0]第i天持有股票所剩的最多现金
        int[][] dp = new int[n][2];
        dp[0][0] -= prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // 优化
    int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int holdStock = -prices[0];
        int saleStock = 0;  // 卖出
        for (int i = 0; i < n; i++) {
            int preStock = holdStock;
            holdStock = Math.max(holdStock, saleStock - prices[i]);
            saleStock = Math.max(saleStock, preStock + prices[i] - fee);
        }

        return saleStock;
    }

}
