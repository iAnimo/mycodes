package leets;

import java.util.Vector;

public class leet061 {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     */
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    // 回溯法中递归函数参数很难一次性确定下来，一般先写逻辑，需要啥参数了，填什么参数。
    void backtracking(int targetSum, int k, int sum, int startIndex) {
        
        // 剪枝操作
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k){
            if (sum == targetSum) {
                result.add(path);
            }
            return;
        }

        for (int i = startIndex; i < 9; i++) {
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i+1);
            sum -= i;
            path.remove(i);
        }
    }

    Vector<Vector<Integer>> combinationSum3(int k, int n) {
        result.clear();
        path.clear();
        backtracking(n, k, 0, 1);
        return result;
    }
}
