package mprojects2;
public class p103 {
    public static void main(String[] args) {
        for (int i = 3; i <= 40; i++) {
            System.out.println(i + " :" + f(i));
        }

        System.out.println("------------------");
        long[] dp = new long[50+10];
        f(50,dp);

        for (int i = 1; i <= 40; i++) {
            System.out.println(i + " :" + dp[i]);
        }
    }

    /**
     * 
     * @param n 方格数
     * @return 
     */
    private static int f(int n) {
        if ( n == 1 ) return 3;
        if ( n == 2 ) return 6;
        return 2 * f(n-2) + f(n-1);
    }
    /**
     * A******B#
     * 1. A=B   f(n-1)*1
     * 2. A!=B  f(n-2)*2
     */

    private static void f(int n,long[] dp) {
        dp[1] = 3;
        dp[2] = 6;
        for (int i = 3; i <= n; i++) {
            dp[i] = 2*dp[i-2] + dp[i-1];
        }
    }
}
