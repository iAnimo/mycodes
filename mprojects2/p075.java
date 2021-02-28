package mprojects2;
import java.util.List;
import java.util.Vector;

public class p075 {

    /**
     * 
     * @param limit 限制条件
     * @param x 取法
     * @param k 当前位置
     * @param m 要取的个数
     */
    public static List<int[]> res = new Vector<>();
    private static void out(int[] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i]; j++) {
                System.out.print((char)('A'+i));
            }
        }
        System.out.println();
    }
    private static void f(int[] limit, int[] x, int k, int m) {
        if ( k == x.length ) {
            if ( m == 0 ) {
                res.add(x);
                // out(x);
            }
            return ;
        }
        for (int i = 0; i <= Math.min(limit[k], m); i++) {
            x[k] = i; //试探
            f ( limit, x, k+1, m-i );
        }
        x[k] = 0; //回溯
    }

    public static void main(String[] args) {
        /**
         * AABBBC  取三个，有哪些取法
         * 
         */
        //出现次数
        int[] limit = { 2, 3, 1 };
        //每个元素所取的个数
        int[] x = new int[limit.length];
        
        f(limit, x, 0, 3);

        for (int[] y : res) {
            out(y);
        }
    }

    
}
