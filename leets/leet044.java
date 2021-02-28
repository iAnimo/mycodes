package leets;

import utils.TreeNode;

public class leet044 {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     */
    // 递归 - 深度优先遍历的方式
    boolean traversal(TreeNode cur, int count) {
        if (cur.left == null && cur.right == null && count == 0) {
            return true; // 遇到叶子节点，并且计数为0
        }
        if (cur.left == null && cur.right == null){
            return false; // 遇到叶子节点而没有找到合适的边，直接返回
        }
        
        if (cur.left != null) {
            count -= cur.left.val;
            if ( traversal(cur.left, count) ) {
                return true;
            }
            count += cur.left.val;
        }

        if (cur.right != null) {
            count -= cur.right.val;
            if ( traversal(cur.right, count) ) {
                return true;
            }
            count += cur.right.val;
        }

        return false;
    } 

    boolean hasPathSum(TreeNode root, int sum) {
        if ( root ==null) {
            return false;
        }
        return traversal(root, sum-root.val);
    }

    // 精简
    boolean hasPathSum2(TreeNode root, int sum) {
        if ( root == null) {
            return false;
        }
        if ( root.left == null && root.right == null && sum == root.val ) {
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

}
