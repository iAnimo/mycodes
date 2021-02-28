package mprojects;

public class m60a {
    
    public double[] twoSum(int n) {

        double all = Math.pow(6, n);

        int[][] dp = new int[n+1][6*n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6*n; j++) {
                for (int k = 1; k <= Math.min(j, 6); k++) {
                    
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        double[] res = new double[1 + 5*n];

        for (int i = n; i <= n*6; i++) {
            res[i-n] = dp[n][i] / all;
        }

        return res;
    }
}
