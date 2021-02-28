package mprojects;

public class m062 {

    /**
     * f(n,m) = (f(n-1,m)+m)%n
     */
    
    public int lastNumber(int n, int m) {
        if ( n == 1 ) {
            return 0;
        }

        return (lastNumber(n-1, m) + m ) % n;
    }
}
