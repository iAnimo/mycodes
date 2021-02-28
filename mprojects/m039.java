package mprojects;

public class m039 {
    public int majority(int[] nums) {
        int val = -1;
        int cnt = 0;
        for (int num : nums) {
            if ( num == val ) {
                cnt ++;
            } else {
                if ( cnt >= 1 ) {
                    cnt --;
                } else {
                    val = num;
                    cnt = 1;
                }
            }
        }
        return val;
    }
    
}
