package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import utils.TreeNode;

public class leet033d {
    
    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     */
    Vector<Double> averageOfLevels(TreeNode root) { 
        Queue<TreeNode> que = new LinkedList<>();
        if ( root != null ) {
            que.add(root);
        }
        Vector<Double> res = new Vector<>();

        while ( !que.isEmpty() ) {
            int size = que.size();
            Double sum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum += node.val;

                if ( node.left != null ) {
                    que.add(node.left);
                }

                if ( node.right != null ) {
                    que.add(node.right);
                }
            }
            res.add(sum/size);
        }

        return res;
    }
}
