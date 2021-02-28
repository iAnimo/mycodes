package leets;

import java.util.Vector;

public class leet066 {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 
     * 说明：解集不能包含重复的子集。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    Vector<Vector<Integer>> subsets(Vector<Integer> nums) {
        result.clear();
        path.clear();
        backtracking(nums, 0);
        return result;
    }

    void backtracking(Vector<Integer> nums, int startIndex) {
        if (startIndex >= nums.size()) {    // 可省略
            return;
        }

        for (int i = startIndex; i < nums.size(); i++) {
            path.add(nums.get(i));    // 子集收集元素
            backtracking(nums, i + 1);  // 注意从i+1开始，元素不重复取
            path.remove(nums.get(i));            // 回溯
        }
    }
}
