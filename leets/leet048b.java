
package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet048b {
    
    // 迭代法 - 使用队列，模拟的层序遍历
    TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if ( t1 == null) {
            return t2;
        }
        if ( t2 == null) {
            return t1;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(t1);
        que.add(t2);

        while ( !que.isEmpty() ) {
            TreeNode n1 = que.poll();
            TreeNode n2 = que.poll();

            n1.val += n2.val;

            // 双侧
            if ( n1.left != null && n2.left != null) {
                que.add(n1.left);
                que.add(n2.left);
            }

            if ( n1.right != null && n2.right != null) {
                que.add(n1.right);
                que.add(n2.right);
            }

            // 单侧
            if ( n1.left == null && n2.left != null) {
                n1.left = n2.left;
            }

            if ( n1.right == null && n2.right != null) {
                n1.right = n2.right;
            }
        }
        return t1;
    }
    
}
