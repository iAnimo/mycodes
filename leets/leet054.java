package leets;

import utils.TreeNode;

public class leet054 {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     */
    TreeNode traversal(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return cur;
        }

        if (cur.val > p.val && cur.val > q.val) {   // p,q同侧
            TreeNode left = traversal(cur.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (cur.val < p.val && cur.val < q.val) {
            TreeNode right = traversal(cur.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return cur;
    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    // 精简
    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }
}
