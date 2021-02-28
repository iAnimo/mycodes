package leets;

import java.util.Vector;

public class leet063 {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(path);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(candidates[i]);
        }
    }

    Vector<Vector<Integer>> combinationSum(int[] candidates, int target) {
        result = new Vector<>();
        path = new Vector<>();
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking2(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(path);
            return;
        }

        // 对总集合排序之后，如果下一层的sum（就是本层的 sum + candidates[i]）已经大于target，
        // 就可以结束本轮for循环的遍历
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i);   // i - 表示可重复取
            sum -= candidates[i];
            path.remove(candidates[i]);
        }
    }

}
