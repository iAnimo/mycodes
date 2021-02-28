package mprojects;

public class m047 {
    public int maxValue(int[][] f) {
        //f[i][j] = max(f[i-1][j],f[i][j-1])
        int m = f.length;
        int n = f[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == 0 && j == 0 ) {
                    continue;
                }
                if ( i == 0 ) {
                    f[i][j] += f[i][j-1];
                } else if ( j == 0 ) {
                    f[i][j] += f[i-1][j];
                } else {
                    f[i][j] += Math.max(f[i-1][j], f[i][j-1]);
                }
            }
        }
        return f[m-1][n-1];
    }
}