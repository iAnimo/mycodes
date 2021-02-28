package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import utils.TreeNode;

public class leet033b {
    
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历
     */
    // 把result数组反转一下就可以了
    Vector<Vector<Integer>> levelOrder(TreeNode root) {
    
        Queue<TreeNode> que = new LinkedList<>();
        if ( root != null ) {
            que.add(root);
        }
        Vector<Vector<Integer>> res = new Vector<>();
        while ( !que.isEmpty() ) {
            int size = que.size();
            Vector<Integer> vec = new Vector<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                vec.add(node.val);
                if ( node.left != null ) {
                    que.add(node.left);
                }

                if ( node.right != null ) {
                    que.add(node.right);
                }
            }
            res.add(vec);
        }

        return res;
    }
}
