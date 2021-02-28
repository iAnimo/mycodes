package mprojects;

public class m016 {

    /**
     * n=9  1001
     * x(9) = x(1*1)*x(0*2)*x(0*4)*x(1*8) = x(9)
     */
    public double myPow(double x, int n) {
        if ( x == 0 ) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if ( b < 0 ) {
            b = -b;
            x = 1/x;//倒数
        }
        while ( b > 0 ) {   //位运算的x倍
            if ( (b&1) == 1 ) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
