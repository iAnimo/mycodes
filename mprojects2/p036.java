package mprojects2;
public class p036 {
    public int process1(char[] str, int i) {
        if ( i == str.length ){ //到达字符串尾部
            return 1;
        }
        if ( str[i] == '0' ){  // 01 - (无法转化) 和 10 - J
            return 0;
        }
        // if ( str[i]
        if ( str[i] == '1' ){
            int res = process1(str, i+1); // i 单独作为部分
            if( i+1 < str.length ) {
                res += process1(str, i+2); // i,i+1 作为一部分
            }
            return res;
        }

        if ( str[i] == '2' ){
            int res = process1(str, i+1); // i 单独作为部分
            if( i+1 < str.length && str[i+1]<='6' ) {
                res += process1(str, i+2); // i,i+1 作为一部分
            }
            return res;
        }
        //3-9:C-I
        return process1(str, i+1);
    }
    //动态规划
    public int dpWays(String s){
        //边界
        if ( s == null || s.length() == 0 ){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];

        //return点为设置dp[i]的时刻
        for (int i = N-1; i >= 0; i --) {
            if ( str[i] == '0' ){  // 01 - (无法转化) 和 10 - J
                dp[i] = 0;
            }
            // if ( str[i]
            if ( str[i] == '1' ){
                dp[i] = dp[i+1]; // i 单独作为部分
                if( i+1 < str.length ) {
                    dp[i] += dp[i+2]; // i,i+1 作为一部分
                }
            }
    
            if ( str[i] == '2' ){
                dp[i] = dp[i+1]; // i 单独作为部分
                if( i+1 < str.length && str[i+1] >= '0' && str[i+1]<='6' ) {
                    dp[i] += dp[i+2]; // i,i+1 作为一部分
                }
            }
        }
        return dp[0];
    }
}
