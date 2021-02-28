package leets;

import java.util.Vector;

public class leet063b {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     */

    /**
     * 所谓去重，其实就是使用过的元素不能重复选取 都知道组合问题可以抽象为树形结构，那么“使用过”在这个树形结构上是有两个维度的， 一个维度是同一树枝上使用过，
     * 一个维度是同一树层上使用过
     */

    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果
    // 需要加一个bool型数组used，用来记录同一树枝上的元素是否使用过。

    void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        if (sum == target) {
            result.add(path);
            return;
        }
        /**
         * 可以看出在candidates[i] == candidates[i - 1]相同的情况下：
         * used[i - 1] == true，说明同一树支candidates[i - 1]使用过 
         * used[i - 1] == false，说明同一树层candidates[i - 1]使用过
         */
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {

            if (candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, sum, i+1, used);   // i+1 - 不可重复取
            used[i] = false;
            sum -= candidates[i];
            path.remove(candidates[i]);
        }
    }

}
