package mprojects;

public class m063 {

    public int maxProfit(int[] prices) {
        
        if ( prices.length == 0 ) {
            return 0;
        }

        int maxv = 0;
        int minv = prices[0];
        for (int i = 1; i < prices.length; i++) {
            
            maxv = Math.max(prices[i]-minv, maxv);
            minv = Math.max(minv, prices[i]);
        }

        return maxv;
    }
    
}
