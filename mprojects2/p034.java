package mprojects2;
import java.util.Arrays;

public class p034 {
    
    //暴力递归
    //N-总格子 M-起始位 K-总步数 P-目标
    public int way1(int N, int M, int K, int P){
        if ( N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N){
            return 0;
        }
        return walk(N,M,K,P);
    }

    private int walk(int N, int cur, int rest, int P) {
        if ( rest == 0 ){
            return cur == P?1:0;
        }
        if ( cur == 1 ){
            return walk(N, 2, rest - 1, P);
        } else if ( cur == N ){
            return walk(N, cur, rest - 1, P);
        }
        return walk(N, cur-1, rest-1, P)+walk(N, cur+1, rest-1, P);
    }
    // 增加缓存(避免重复计算) - 计划搜索
    public int way2(int N, int M, int K, int P){
        if ( N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N){
            return 0;
        }
        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return walkCache(N,M,K,P,dp);
    }

    private int walkCache(int N, int cur, int rest, int P, int[][] dp) {
        if ( dp[cur][rest] != -1 ){
            return dp[cur][rest];
        }

        if ( rest == 0 ){
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if ( cur == 1 ){
            dp[cur][rest] = walkCache(N, 2, rest - 1, P, dp);
            return dp[cur][rest];
        } else if ( cur == N ){
            dp[cur][rest] = walkCache(N, cur, rest - 1, P, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = walkCache(N, cur-1, rest-1, P, dp)+walkCache(N, cur+1, rest-1, P, dp);
        return dp[cur][rest];
    }
    //动态规划
    /**
     * 1.dp[0][x] = 0;dp[x][0] = 0;
     * 2.dp[P][0] = 1
     * 3.dp[i][j] = dp[i-1][j-1] + dp[i+1][j-1]
     * 注：越界位置为零
     */

    /**
     * 常见的4中尝试模型
     * 1. 从左往右的尝试模型
     * 2. 范围上的尝试模型
     * 3. 多样本位置全对应的尝试模型
     * 4. 寻找业务限制的尝试模型
     */
}
