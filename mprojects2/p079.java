package mprojects2;
public class p079 {
    
    /**
     * 解不定方程
     * 97x+127y=1
     * 
     * A>B  A = A/B * B + A%B
     * A*x+B*y = gcd(A,B);
     *         = gcd(B,A%B) 
     * B*(A/B * x + y) + (A%B)*x = gcd(B,A%B)
     * B*x' + (A%B)*y' = gcd(B,A%B)
     * x' = A/B * x + y     --- x = y'
     * y' = x               --- y = x'- A/B * y'
     */

     public static void main(String[] args) {
        int[] xy = new int[2];
        int a = e_gcd(97,127,xy);
        System.out.println(a);
        System.out.println(xy[0]+" "+xy[1]);
     }

     //返回最大公约数
     private static int e_gcd(int a, int b, int[] xy) {
        if ( b == 0 ){
            xy[0] = 1; //x
            xy[1] = 0; //y
            return a;
        }
        int ans = e_gcd(b, a%b, xy); 
        // 以下是回溯过程
        int t = xy[0];
        xy[0] = xy[1];
        xy[1] = t - a/b*xy[0];

        return ans;
     }
}
