package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet043b {
    
    // 迭代法
    int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        if ( root != null) {
            que.add(root);
        }
        int res = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if ( i == 0) {
                    res = node.val;   
                }
                if ( node.left != null) {   // 左
                    que.add(node.left);
                }
                if ( node.right != null) {
                    que.add(node.right);
                }
            }
            
        }
        return res;
    }
}
