package mprojects;

public class m056a {
    
    public int[] singleNumbers(int[] nums) {
        
        int sum = 0;
        for (int x : nums) {
            sum ^= x;
        }

        int i0 = 0;
        while ( (sum >> i0 & 1) == 0 ) {

            i0 ++;
        }

        int first = 0;
        for (int x : nums) {
            
            if ( (x >> i0 & 1) == 0 ) {
                first ^= x;
            }
        }

        int second = sum ^ first ;
        
        return new int[] {first, second};
    }
}
