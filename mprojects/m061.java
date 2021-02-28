package mprojects;

import java.util.Arrays;

public class m061 {

    public boolean isStraight(int[] nums) {

        if ( nums.length != 5 ) {
            return false;
        }

        Arrays.sort(nums);

        int zeroi = 0;
        while ( nums[zeroi] == 0 ) {
            zeroi ++;
        }

        for (int i = zeroi+1; i < nums.length; i++) {
            if ( nums[i-1] == nums[i] ) {
                return false;
            }
        }

        return nums[4] - nums[zeroi] <= 4;
    }
    
}
