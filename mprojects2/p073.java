package mprojects2;
public class p073 {
    /**
     *          0
     *        1   2
     *       3  4  5
     *      6  7 8  9
     */

    static int N = 0;
    static void f(int[] a, int k){
        //出口
        if ( k == a.length -1 ) {
            output(a);
            return ;
        }

        for (int j = k; j < a.length; j++) {
            {int tmp = a[k]; a[k] = a[j]; a[j] = tmp;} //试探
            f( a, k+1 );
            {int tmp = a[k]; a[k] = a[j]; a[j] = tmp;} //回溯
        }
    }
    
    private static void output(int[] a) {
        //判定当前值是否满足条件 - 穷举
        //打印当前a
        N ++;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        f( a, 0 );
    }
}
