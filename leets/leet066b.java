package leets;

import java.util.Vector;

public class leet066b {
    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 
     * 说明：解集不能包含重复的子集。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    Vector<Vector<Integer>> subsets(Vector<Integer> nums) {
        result.clear();
        path.clear();
        boolean[] used = new boolean[nums.size()];
        backtracking(nums, 0, used);
        return result;
    }

    void backtracking(Vector<Integer> nums, int startIndex, boolean[] used) {
        result.add(path);
        for (int i = startIndex; i < nums.size(); i++) {

            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            if (i > 0 && nums.get(i) == nums.get(i - 1) && !used[i - 1]) {
                continue;
            }

            path.add(nums.get(i));
            used[i] = true;
            backtracking(nums, i+1, used);
            used[i] = false;
            path.remove(nums.get(i));
        }
    }
}
