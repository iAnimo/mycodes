package leets;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class leet067 {
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    Vector<Vector<Integer>> findSubsequences(Vector<Integer> nums) {
        result.clear();
        path.clear();
        backtracking(nums, 0);
        return result;
    }

    void backtracking(Vector<Integer> nums, int startIndex) {
        if (path.size() > 1) {
            result.add(path);
            // 注意这里不要加return，要取树上的节点
        }

        Set<Integer> uset = new HashSet<>();
        for (int i = startIndex; i < nums.size(); i++) {
            if ((!path.isEmpty() && nums.get(i) < path.get(path.size()-1) || uset.contains(nums.get(i)) )) {
                continue;
            }

            uset.add(nums.get(i));

            path.add(nums.get(i));
            backtracking(nums, i+1);
            path.remove(nums.get(i));
        }
    }

    // 用数组来做哈希
    void backtracking2(Vector<Integer> nums, int startIndex) {
        if (path.size() > 1) {
            result.add(path);
        }

        int used[] = new int[201];
        for (int i = startIndex; i < nums.size(); i++) {
            if ((!path.isEmpty() && nums.get(i) < path.get(path.size()-1)) || used[nums.get(i)+100] == 1) {
                continue;
            }
            used[nums.get(i)+100] = 1;

            path.add(nums.get(i));
            backtracking(nums, i+1);
            path.remove(nums.get(i));
        }

    }
}
