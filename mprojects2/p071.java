package mprojects2;
public class p071 {
    /**
     * 递归的核心：递归函数其使用的参数
     * 加入算术符号(+,-)，使其结果为S
     */
    
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        f(a,8,"",110);
    }

    /**
     * 
     * @param a 参加运算的元素
     * @param i 当前考虑的位置
     * @param res 当前算式
     * @param s 计算目标
     */
    private static void f(int[] a, int i, String res, int s) {

        if ( i == 0 ) {
            if ( a[0] == s ) {
                System.out.println( a[0] + res );
            }
            return;
        }

        f( a, i-1, "+"+ a[i] + res, s - a[i] );
        f( a, i-1, "-"+ a[i] + res, s + a[i] );

        //回溯
        int old = a[i-1];
        //字符串转数
        a[i-1] = Integer.parseInt(""+ a[i-1] + a[i]);
        f( a, i-1, res, s );

        //回溯
        a[i-1] = old;
    }

}
