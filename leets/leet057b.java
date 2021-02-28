package leets;

import utils.TreeNode;

public class leet057b {
    /**
    * 迭代法
     */
    TreeNode trimBST(TreeNode root, int low, int high)  {
        if (root == null) {
            return null;
        }

        while (root.val < low || root.val > high) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        TreeNode cur = root;
        // 处理左孩子元素小于L的情况
        while (cur != null) {  
            while (cur.left != null || cur.left.val > high) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }

        // 处理右孩子大于R的情况
        cur = root;
        while (cur != null) {
            while (cur.right != null || cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }
}
