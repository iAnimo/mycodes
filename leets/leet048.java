package leets;

import utils.TreeNode;

public class leet048 {
    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠
     */
    // 递归
    TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2; // 如果t1为空，合并之后就应该是t2
        if (t2 == null) return t1; // 如果t2为空，合并之后就应该是t1

        // 合并
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    // 不修改输入树的结构，前序遍历
    TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2; // 如果t1为空，合并之后就应该是t2
        if (t2 == null) return t1; // 如果t2为空，合并之后就应该是t1

        // 合并
        TreeNode root = new TreeNode(0);
        root.val = t1.val + t2.val;
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }
}
