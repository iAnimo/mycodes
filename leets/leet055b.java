package leets;

import utils.TreeNode;

public class leet055b {
    /**
     * 迭代
     */
    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            parent = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        TreeNode node = new TreeNode(val);
        if (val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return root;
    }
}
