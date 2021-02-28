package leets;

import utils.TreeNode;

public class leet036 {

    /**
     * 给定一个二叉树，找出其最大深度。
     */
    // 递归法
    int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 左右中
        int leftD = getDepth(node.left);
        int rightD = getDepth(node.right);

        return 1 + Math.max(leftD, rightD);
    }

    // 精简
    int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }

}
