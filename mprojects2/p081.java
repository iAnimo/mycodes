package mprojects2;
public class p081 {
    
    public static void main(String[] args) {
        int[] a = { 2,5,12,14};
        f(a);
    }

    /**
     * 模2加法(异或)解法
     * 0010
     * 0101
     * 1100
     * 1110
     * ------
     * 0101
     */
    private static void f(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum ^= a[i];
        }
        if( sum == 0 ) {
            System.out.println("loss");
            return;
        }
        //抽取
        for (int i = 0; i < a.length; i++) {
            int x = sum ^ a[i];
            if ( x < a[i] ) System.out.println(a[i] + "-->" + x);
        }
    }
}
