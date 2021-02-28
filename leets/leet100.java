package leets;

import java.util.Arrays;
import java.util.Vector;

public class leet100 {
    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     */
    // 回溯的解法，以下是本题转变为组合总和问题的回溯法代码：
    Vector<Vector<Integer>> result = new Vector<>();
    Vector<Integer> path = new Vector<>();

    int findTargetSumWays(Vector<Integer> nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        if (s > sum) {
            return 0;
        }
        if ((s + sum) % 2 == 1) {   // 无法得到结果
            return 0;
        }

        /**
         * left + right = sum 
         * left - right = target
         * 
         * => left = (target+sum) / 2;
         *  */ 
        int bagSize = (s+sum) / 2;
        result.clear();
        path.clear();
        Arrays.sort(nums.toArray());

        backtracking(nums, bagSize, sum, 0);

        return result.size();

    }

    void backtracking(Vector<Integer> candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(path); 
        }
        
        for (int i = startIndex; i < candidates.size() && sum + candidates.get(i) <= target; i++) {
            
            sum += candidates.get(i);
            path.add(candidates.get(i));

            backtracking(candidates, target, sum, i+1);

            sum -= candidates.get(i);
            path.remove(candidates.get(i));

        }
    }

}
