package mprojects;

public class m019 {
    // 正则表达式匹配
    public boolean isMatch(String str, String pstr) {
        char[] s = str.toCharArray();
        char[] p = str.toCharArray();
        //s的前i个字符与p的前j个字符匹配
        int n = s.length;
        int m = p.length;
        boolean[][] dp = new boolean[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if ( j == 0 ) {
                    dp[i][j] = (i==0);
                } else {
                    if ( p[j-1] != '*' ) {
                        if ( i > 0 && ( s[i-1] == p[j-1] || p[j-1] == '.') ) {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    } else {
                        if ( j >= 2 ) {
                            dp[i][j] = dp[i][j-2];
                        }
                        if ( i >= 1 && j>=2 && ( s[i-1] == p[j-2] && p[j-2] == '_' ) ) {
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}
