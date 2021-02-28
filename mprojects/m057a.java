package mprojects;

import java.util.HashSet;
import java.util.Set;

public class m057a {
    
    public int[] twoSum( int[] nums, int target ) {

        Set<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            
            if ( hash.contains(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
        }

        return null;
    }

    public int[] twoSum2( int[] nums, int target ) {

        int i = 0;
        int j = nums.length;

        while ( i < j ) {

            int s = nums[i] + nums[j];
            if ( s < target ) {
                i ++;
            } else if ( s > target ) {
                j --;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return null;
    }
}
