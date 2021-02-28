package leets2;

import java.util.HashMap;
import java.util.Map;

public class leet216 {
    // 哈希表减少时间复杂度
    int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{ i, index.get(other) };
            }
        }
        return new int[]{-1, -1};
    }
}
