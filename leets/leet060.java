package leets;

import java.util.Vector;

public class leet060 {
    /**
     * 回溯法，一般可以解决如下几种问题：
     * 
     * 组合问题：N个数里面按一定规则找出k个数的集合 
     * 排列问题：N个数按一定规则全排列，有几种排列方式 
     * 切割问题：一个字符串按一定规则有几种切割方式
     * 子集问题：一个N个数的集合里有多少符合条件的子集 棋盘问题：N皇后，解数独等等
     */

    // 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    // 定义两个全局变量，一个用来存放符合条件单一结果，一个用来存放符合条件结果的集合。
    Vector<Vector<Integer>> result; // 存放符合条件结果的集合
    Vector<Integer> path; // 用来存放符合条件结果

    // 需要startIndex来记录下一层递归，搜索的起始位置。
    void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(path);
            return;
        }

        for (int i = startIndex; i <= n; i++) {
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
