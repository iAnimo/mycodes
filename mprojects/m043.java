package mprojects;

public class m043 {
    /**
     * 切分 high cur low
     * 4507
     * high-45, cur-0, low-7: res = high*x
     * 0010 - 4419 : 000 - 449 = 450
     * 
     * 4517
     * high-45, cur-1, low-7: res = high*x + low + 1
     * 0010 - 4517 : 000 - 457 = 458
     * 
     * 4527
     * high-45, cur-2, low-7: res = (high+1)*x
     * 0010 - 4519 : 460
     * 
     * 7
     * high-0, cur-0, low-0: res = (high+1)*x
     * 007 : 1
     * 
     */
    public int countDigitOne(int n) {
        int x = 1;
        int res = 0;
        int high = n/10;
        int cur = n % 10;
        int low = 0;
        while ( high != 0 || cur != 0 ){
            if ( cur == 0 ) {
                res += high * x;
            } else if ( cur == 1 ) {
                res += high * x + low + 1;
            } else {
                res += (high+1) * x;
            }
            low += cur * x;
            cur = high % 10;
            high /= 10;
            x *= 10;
        }
        return res;
    }
    
}
