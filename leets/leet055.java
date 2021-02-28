package leets;

import utils.TreeNode;

public class leet055 {
    /**
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
     * 返回插入后二叉搜索树的根节点。输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
     */
    // 递归
    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    /**
     * 没有返回值，需要记录上一个节点（parent），遇到空节点了，就让parent左孩子或者右孩子指向新插入的节点。然后结束递归。
     */
    
    TreeNode parent;
    void traversal(TreeNode cur, int val) {
        if (cur == null) {
            TreeNode node = new TreeNode(val);
            if (val > parent.val) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return;
        }
        parent = cur;
        if (cur.val > val) {
            traversal(cur.left, val);
        }

        if (cur.val < val) {
            traversal(cur.right, val);
        }
        return;
    }

    TreeNode insertIntoBST2(TreeNode root, int val) {
        parent = new TreeNode(0);
        if (root == null) {
            root = new TreeNode(val);
        }
        traversal(root, val);
        return root;
    }
}
