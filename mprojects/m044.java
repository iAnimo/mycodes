package mprojects;

public class m044 {

    /**
     * n = 12
     * n   d  s   c 
     * 12  1  1   9
     * 3   2  10  180
     * 
     * n = 10+2/2 = 11
     */
    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while ( n > count ) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)- '0';
    }
    public static void main(String[] args) {
        System.out.println(findNthDigit(13));
    }
    
}
