package leets;

import utils.TreeNode;

public class leet042 {
    /**
     * 计算给定二叉树的所有左叶子之和。
     */
    // 递归法
    int sumOfLeftLeaves(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        int leftS = sumOfLeftLeaves(root.left);
        int rightS = sumOfLeftLeaves(root.right);

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        int sum = midValue + leftS + rightS;
        return sum;
    }

    // 精简
    int sumOfLeftLeaves2(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        return midValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
