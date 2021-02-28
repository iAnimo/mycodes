
package leets;

import java.util.Vector;

public class leet060b {
    /**
     * 剪枝优化
     */
    // 定义两个全局变量，一个用来存放符合条件单一结果，一个用来存放符合条件结果的集合。
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    // 需要startIndex来记录下一层递归，搜索的起始位置。
    void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(path);
            return;
        }


        // 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        for (int i = startIndex; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            backtracking(n, k, i+1);
            path.remove(i);
        }
    }

    Vector<Vector<Integer>> combine(int n, int k) {
        result.clear();
        path.clear();
        backtracking(n, k, 1);
        return result;
    }
}
