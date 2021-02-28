package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import utils.TreeNode;

public class leet033 {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。（即逐层地，从左到右访问所有节点）。
     */
    //队列先进先出，符合一层一层遍历的逻辑
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
