package mprojects2;
public class p089 {
    
    public static void main(String[] args) {
        int[] a = { 2,3,-5,6,-5,3,-9 }; //6
        int[] a2 = { 2,4,-7,5,2,-1,2,-4,3 }; //8
        System.out.println(f(a));
        System.out.println(f(a2));
    }

    private static int f(int[] a) {
       return f ( a, 0, a.length );
    }

    private static int f(int[] a, int L, int R) {
        if ( R-L == 1 ) {
            if ( a[L] > 0 ) return a[L];
            return 0;
        }

        int M = L + (R-L)/2;
        int t1 = f( a, L, M );
        int t2 = f( a, M, R );

        //向左扩展
        int ml = 0;
        int sum = 0;
        for (int i = M-1; i >= L; i--) {
            sum += a[i];
            if ( sum > ml ) ml = sum;
        }

        //向右扩展
        int mr = 0;
        sum = 0;
        for (int i = M; i < R; i++) {
            sum += a[i];
            if ( sum > mr ) mr = sum;
        }

        int t3 = ml + mr;
        int max = 0;
        if ( t1 > max ) max = t1;
        if ( t2 > max ) max = t2;
        if ( t3 > max ) max = t3;

        return max;
    }
}
