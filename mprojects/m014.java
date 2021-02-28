package mprojects;

public class m014 {
    /**
     * 令乘积最大
     * n    result
     * 2    1*1=1
     * 3    1*2=2
     * 4    3*1 or 2*2
     * 5    3*(n-3)>n so 3*2=6
     * ...
     */
    public static int cuttingRope( int n ) {
        int p = 10000007;
        long res = 1;
        if ( n <= 3 ) {
            return n-1;
        }
        if ( n%3 == 1 ) {
            res *= 4;
            n -= 4;
        } else if ( n%3 == 2 ) {
            res *= 2;
            n -= 2;
        }
        //此时n是3的倍数
        while ( n != 0 ) {
            res *= 3;
            n -= 3;
        }

        return (int) res % p;
    }

    //动态规划
    public static int cuttingRope2( int n ) {
        if ( n < 2 ) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max( Math.max(j*dp[i-j], j*(i-j)), dp[i] );
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(9));
        System.out.println(cuttingRope2(9));
    }
}
