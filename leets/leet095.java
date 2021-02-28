package leets;

public class leet095 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */
    /**
     * dp[3]，就是 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
     * 
     * 有2个元素的搜索树数量就是dp[2]。
     * 
     * 有1个元素的搜索树数量就是dp[1]。
     * 
     * 有0个元素的搜索树数量就是dp[0]。
     * 
     * 所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     */

    // 时间复杂度O(n^2) 空间复杂度O(n)
    int numTrees(int n) {
        // dp[i] ：1到i为节点组成的二叉搜索树的个数为dp[i]。
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 递推公式：dp[i] += dp[j - 1] * dp[i - j]; ，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
