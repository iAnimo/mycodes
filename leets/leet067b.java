package leets;

import java.util.Vector;

public class leet067b {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    void backtracking(Vector<Integer> nums, boolean[] used) {
        if (path.size() == nums.size()) {
            result.add(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 如果要对树层中前一位去重，就用used[i - 1] == false，
            // 如果要对树枝前一位去重用used[i - 1] == true
            if (i > 0 && nums.get(i) == nums.get(i-1) && used[i-1] == false) {
                continue;
            }

            if (used[i] == false) {
                used[i] = true;
                path.add(nums.get(i));
                backtracking(nums, used);
                path.remove(nums.get(i));
                used[i] = false;
            }
        }
    }

    Vector<Vector<Integer>> permuteUnique(Vector<Integer> nums) {
        result.clear();
        path.clear();
        boolean[] used = new boolean[nums.size()];
        backtracking(nums, used);
        return result;
    }
}

