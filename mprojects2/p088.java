package mprojects2;
public class p088 {
    
    public static void main(String[] args) {
        int[] a = { 1,2,3,5,7,8,9,10 };
        System.out.println(f(a, 7));
    }

    private static int f(int[] a, int x) {
        if ( x > a[a.length-1] ) return -1;
        return f( a, 0, a.length, x );
    }

    /**
     * 含有L，不含有R
     */
    private static int f(int[] a, int L, int R, int x) {
        if ( R-L == 1 ) {
            if ( a[L] > x ) return L;
            return R;
        }
        int M = L+(R-L)/2;
        if ( x >= a[M] ) return f( a,M,R,x );
        return f( a,L,M,x );
    }
}
