package leets;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class leet039 {
    
    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     */
    // 左右中
    // 递归
    int countNodes(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        int leftN = countNodes(root.left);
        int rightN = countNodes(root.right);

        return 1+leftN+rightN;
    }

    // 迭代法
    int countNodes2(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
         
        int res = 0;
        while ( !que.isEmpty() ) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                res ++;
                if ( node.left != null){
                    que.add(node.left);
                }
                if ( node.right != null){
                    que.add(node.right);
                }
            }
        }

        return res;

    }
}
