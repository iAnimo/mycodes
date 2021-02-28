package mprojects2;
public class p060 {
    //青蛙能否跳到最后 - O(N^2)
    // dp[j] = 枚举i {dp[i] AND i+a[i] >= j}
    public boolean canJump(int[] A){
        int N = A.length;
        boolean[] dp = new boolean[N];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            dp[i] = false;
            for (int j = 0; j < dp.length; j++) {
               if ( dp[i] && i + A[i] >= j ){
                   dp[j] = true;
                   break;
               } 
            }
        }
        return dp[N-1];
    }
}
