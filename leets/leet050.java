package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet050 {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     */
    // 中序遍历下，输出的二叉搜索树节点的数值是有序序列。
    // 递归法
    Vector<Integer> inorder = new Vector<>();

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        inorder.add(root.val);
        traversal(root.right);

    }

    boolean isValidBST(TreeNode root) {
        inorder.clear();
        traversal(root);

        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 但其实不用转变成数组，可以在递归遍历的过程中直接判断是否有序
    long maxValue = Long.MAX_VALUE;
    boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBST = isValidBST2(root.left);

        if ( maxValue < root.val ) {
            maxValue = root.val;
        } else {
            return false;
        }
        boolean rightBST = isValidBST2(root.right);

        return leftBST && rightBST;
    }

    // 用来记录前一个节点 
    TreeNode pre = null;
    boolean isValidBST3(TreeNode root) {
        if (root == null ) {
            return true;
        }
        boolean leftBST = isValidBST3(root.left);
        if ( pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        boolean rightBST = isValidBST3(root.right);

        return leftBST && rightBST;
    }

}
