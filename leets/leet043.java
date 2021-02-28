package leets;

import utils.TreeNode;

public class leet043 {
    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     */
    // 层序遍历
    // 递归 -- 中左右
    int maxLen =  Integer.MAX_VALUE;
    int maxValue = 0;
    
    int findBottomLeftValue(TreeNode root) {
        traversal(root, 0);
        return maxValue;
    }

    void traversal(TreeNode root, int leftLen) {
        
        if (root.left == null && root.right == null) {
            if ( leftLen > maxLen ) {
                maxLen = leftLen;
                maxValue = root.val;
            }   
            return ;
        }

        if ( root.left != null) {
            leftLen ++;
            traversal(root.left, leftLen);
            leftLen --;
        }

        if ( root.right != null) {
            leftLen ++;
            traversal(root.right, leftLen);
            leftLen --;
        }
        return ;
    }

    void traversal2(TreeNode root, int leftLen) {
        
        if (root.left == null && root.right == null) {
            if ( leftLen > maxLen ) {
                maxLen = leftLen;
                maxValue = root.val;
            }   
            return ;
        }

        if ( root.left != null) {
            traversal(root.left, leftLen + 1);
        }

        if ( root.right != null) {
            traversal(root.right, leftLen + 1);
        }
        return ;
    }

}
