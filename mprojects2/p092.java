package mprojects2;
public class p092 {
    public static void main(String[] args) {
        System.out.println(f(5,4));
        int[][] dp = new int[100][100];
        f(20,15,dp);
        System.out.println(dp[20][15]);
        System.out.println(dp[5][4]);
    }

    private static void f(int m, int n, int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = 1;
            dp[1][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10000;
            }
        }
    }

    private static int f(int m, int n) {
        if ( m == 1 || n == 1 ) return 1;
        return f(m-1,n)+f(m,n-1);
    }


}
