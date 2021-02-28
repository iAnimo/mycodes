package mprojects2;
public class p035 {
    
    public int getMaxValue2(int[] w, int[] v, int bag ){
        return process2(w, v, 0, bag);
    }

    public int process2(int[] w, int[] v, int i, int rest) {
        if ( rest < 0 ){
            return -1;
        }
        if ( i == w.length ){
            return 0;
        }
        int p1 = process2(w, v, i+1, rest);
        int p2 = Integer.MAX_VALUE;
        if ( rest >= w[i] ){
            p2 = v[i] + process2(w, v, i+1, rest-w[i]);
        }
        return Math.max(p1, p2);
    }
    //动态规划
    public int getMaxValue3(int[] w, int[] v, int bag ){
        return dpWays(w, v, bag);
    }

    private int dpWays(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        for (int i = N-1; i >= 0; i--) {
            for (int rest = 0; rest <= bag; rest ++) {
                int p1 = dp[i+1][rest];
                // int p2 = Integer.MAX_VALUE;
                int p2 = -1;
                if ( rest >= w[i] ){
                    p2 = v[i] + dp[i+1][rest-w[i]];
                }
                dp[i][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }
}
