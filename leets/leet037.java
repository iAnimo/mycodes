package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.NTreeNode;

public class leet037 {
    
    /**
     * 给定一个 N 叉树，找到其最大深度。
     */
    // 递归法
    int maxDepth(NTreeNode root) {
        if ( root == null) {
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.childSize; i++) {
            depth = Math.max(depth, maxDepth(root.chilNodes[i]));
        }
        return depth + 1;
    }

    // 迭代法
    int maxDepth2(NTreeNode root) {

        Queue<NTreeNode> que = new LinkedList<>();
        if (root != null){
            que.add(root);
        }
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth ++;
            for (int i = 0; i < size; i++) {
                NTreeNode node = que.poll();
                for (int j = 0; j < node.childSize; j++) {
                    que.add(node.chilNodes[j]);
                }
            }
        }

        return depth;

    }
}
