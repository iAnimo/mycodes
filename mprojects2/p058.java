package mprojects2;
public class p058 {
    // 递归解法 - 有重复计算
    public int coinChange(int X) {
        if (X == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        if (X >= 2) {
            res = Math.min(coinChange(X - 2) + 1, res);
        }
        if (X >= 5) {
            res = Math.min(coinChange(X - 5) + 1, res);
        }
        if (X >= 7) {
            res = Math.min(coinChange(X - 7) + 1, res);
        }
        return res;
    }

    // 动态规划
    public int coinChange2(int[] C, int M) {
        int[] dp = new int[M + 1];
        int N = C.length;
        for (int i = 1; i <= M; i++) { // 0-M
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (i >= C[j] && dp[i - C[j]] != Integer.MAX_VALUE) {
                    res = Math.min(res, dp[i - C[j]] + 1);
                }
            }
            dp[i] = res;
        }
        if (dp[M] == Integer.MAX_VALUE) {
            dp[M] = -1;
        }
        return dp[M];
    }

    public static void main(String[] args) {
        int[] C = { 3, 5, 7 };
        int M = 1;
        System.out.println(new p058().coinChange2(C, M));
    }
}
