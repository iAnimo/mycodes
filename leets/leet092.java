package leets;

public class leet092 {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 
     * 问总共有多少条不同的路径？
     */
    /*
     * 用图论里的深搜，来枚举出来有多少种路径。 
     * 
     * 深搜代码的时间复杂度为O(2^(m + n - 1) - 1)
     * 
     * 树的深度：deep = m+n-1;
     * 树节点数 2^deep - 1
     */

    int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i > m || j > n) { // 越界返回
            return 0;
        }
        if (i == m && j == n) { // 一种方法
            return 1;
        }
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

}
