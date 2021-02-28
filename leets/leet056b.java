package leets;

import utils.TreeNode;

public class leet056b {
    /**
     * 迭代法
     */
    TreeNode deleteOneNode(TreeNode target) {
        if (target == null) {
            return target;
        }
        if ( target.right == null) {
            return target.left;
        }
        TreeNode cur = target.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = target.left;
        return target.right;    // 将树转移
    }
    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (pre == null) {
            return deleteOneNode(cur);
        }

        if (pre.left != null && pre.left.val == key) {
            pre.left = deleteOneNode(cur);
        }

        if (pre.right != null && pre.right.val == key) {
            pre.right = deleteOneNode(cur);
        }

        return root;
    }
    
}
