package leets;

import java.util.HashSet;
import java.util.Set;

public class leet012 {
    
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        while ( true ) {
            int sum = sumit(n);
            if ( sum == 1 ) {
                return true;
            }

            if ( set.contains(sum) ) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }

    }

    private int sumit(int n) {

        int res = 0;
        while ( n != 0 ) {
            res += (n%10) * (n%10);
            n = n/10;
        }

        return res;
    }
}
