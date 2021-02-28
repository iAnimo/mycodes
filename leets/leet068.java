package leets;

import java.util.Vector;

public class leet068 {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    void backtracking(Vector<Integer> nums, Vector<Boolean> used) {
        if (path.size() == nums.size()) {
            result.add(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (used.get(i) == true) {
                continue;
            }
            used.set(i, true);
            path.add(nums.get(i));
            backtracking(nums, used);
            path.remove(nums.get(i));
            used.set(i, false);
        }
    }


    Vector<Vector<Integer>> permute(Vector<Integer> nums) {
        result.clear();
        path.clear();
        Vector<Boolean> used = new Vector<>(nums.size());   // 无默认值 - 不推荐使用
        backtracking(nums, used);
        return result;
    }
}
