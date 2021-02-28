package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet038 {
    /**
     * 给定一个二叉树，找出其最小深度。
     */
    // 递归法
    int minDepth(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        //左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度。
        if ( root.left == null && root.right != null){
            return 1 + minDepth(root.right); 
        }

        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left); 
        }

        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

    // 迭代法
    int minDepth2(TreeNode root) {

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

                if ( node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
