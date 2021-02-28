package leets;

import utils.TreeNode;

public class leet035 {
    
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    // 正是因为要遍历两棵树而且要比较内侧和外侧节点，
    // 所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中

    // 递归法
    boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        // 排除了空节点，再排除数值不相同的情况
        else if (left.val != right.val) return false;

        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        boolean outside = compare(left.left, right.right);   // 左子树：左、 右子树：右
        boolean inside = compare(left.right, right.left);    // 左子树：右、 右子树：左
        return outside && inside;
    }

    boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

}
