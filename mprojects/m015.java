package mprojects;

public class m015 {
    public static int hamingWeight( int n ) {
        int count = 0;
        while( n != 0 ) {
            count ++;
            n = n&(n-1);
        }
        return count;
    }
}
