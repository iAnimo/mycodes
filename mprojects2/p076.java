package mprojects2;
public class p076 {
    


    /**
     * 
     * @param a 成员限定
     * @param k 当前考虑对象
     * @param n 目标名额
     * @param res 决定好的结果
     */
    private static void f(int[] a, int k, int n, String res) {
        if ( k == a.length ){
            if ( n == 0 ) {
                System.out.println(res);
            }
            return;
        }

        String t = res;
        for (int i = 0; i < a[k]; i++) {
            f(a, k+1, n-i, t);
            t += (char) (k+'A');
        }
    }

    
    public static void main(String[] args) {
        int[] a = { 4,2,2,1,1,3 };
        f( a, 0, 5, "");
    }
}
