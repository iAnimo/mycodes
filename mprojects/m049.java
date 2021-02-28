package mprojects;

public class m049 {
    public int nthNumber(int n) {
        int[] f = new int[n];
        int[] pos = new int[3]; //2,3,5
        int a;
        int b;
        int c;
        int mini;
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            a = f[pos[0]] * 2;
            b = f[pos[1]] * 3;
            c = f[pos[2]] * 5;
            mini = Math.min(Math.min(a, b), c);
            if ( a == mini ) {
                pos[0] ++;
            }
            if ( b == mini ) {
                pos[1] ++;
            }
            if ( c == mini ) {
                pos[2] ++;
            }
            f[i] = mini;
        }
        return f[n-1];
    }
    
}
