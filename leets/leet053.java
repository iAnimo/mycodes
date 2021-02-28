package leets;

import utils.TreeNode;

public class leet053 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    // 后序遍历就是天然的回溯过程，最先处理的一定是叶子节点。
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else { // (left == null && right == null)
            return null;
        }
    }

    // 简化
    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        
        return left;
    }
}
