package leets;

import java.util.HashMap;
import java.util.Map;

public class leet013 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        
        if ( nums.length == 0 ) {
            return new int[]{};
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], i);
            if ( map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }
}
