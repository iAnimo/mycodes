package leets;

import java.util.Arrays;
import java.util.Vector;

public class leet016 {

    /**
     * 四数之和，和三数之和是一个思路，都是使用双指针法, 基本解法就是在三数之和 的基础上再套一层for循环。
     */

    public Vector<Vector<Integer>> fourSum(int[] nums, int target) {

        Vector<Vector<Integer>> res = new Vector<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            // 这种剪枝是错误的，这道题目target 是任意值 
            // if (nums[k] > target) {
            //     return result;
            // }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k; i < nums.length; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (r > l) {
                    if (nums[k] + nums[i] + nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[k] + nums[i] + nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        Vector<Integer> tmp = new Vector<>();
                        tmp.add(nums[k]);
                        tmp.add(nums[i]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);

                        res.add(tmp);

                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }

                        while (r > l && nums[l] == nums[l + 1]) {
                            l++;
                        }

                        r--;
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
