package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet036b {

    // 迭代法
    int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
            }
        }

        return depth;
    }
}
