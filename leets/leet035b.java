package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;


public class leet035b {
    
    // 迭代法 - 使用队列或栈，其顺序不变
    
    boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root.left);
        que.add(root.right);

        while ( !que.isEmpty() ) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            if ( left == null && right == null ) {
                continue;
            }

            /**
            * left != null || right != null || left.val != right.val 
             */
            if (left != null && right != null && left.val != right.val) {
                que.add(left.left);
                que.add(right.right);
                que.add(left.right);
                que.add(right.left);
            }else {
                return false;
            }
            
        }
        return true;
    }
}
