package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import utils.NTreeNode;

public class leet033e {
    
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。(即从左到右，逐层遍历)。
     */
    Vector<Vector<Integer>> levelOrder(NTreeNode root) {
    
        Queue<NTreeNode> que = new LinkedList<>();
        if ( root != null ) {
            que.add(root);
        }
        Vector<Vector<Integer>> res = new Vector<>();
        while ( !que.isEmpty() ) {
            int size = que.size();
            Vector<Integer> vec = new Vector<>();

            for (int i = 0; i < size; i++) {
                NTreeNode node = que.poll();
                vec.add(node.val);
                int c = 0;
                while (c < node.childSize) {
                    que.add(node.chilNodes[c]);
                }
            }
            res.add(vec);
        }

        return res;
    }
}
