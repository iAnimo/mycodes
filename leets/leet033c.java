package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import utils.TreeNode;

public class leet033c {
    
    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */

    Vector<Integer> rightSideView(TreeNode root) { 
        Queue<TreeNode> que = new LinkedList<>();
        if ( root != null ) {
            que.add(root);
        }
        Vector<Integer> res = new Vector<>();

        while ( !que.isEmpty() ) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if ( i == (size - 1) ) {
                    res.add(node.val);
                }

                if ( node.left != null ) {
                    que.add(node.left);
                }

                if ( node.right != null ) {
                    que.add(node.right);
                }
            }
        }

        return res;
    }
}
