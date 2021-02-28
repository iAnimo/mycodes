package leets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utils.TreeNode;

public class leet034 {

    /**
     * 翻转一棵二叉树。
     */
    // 递归法
    TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        swap(root.left, root.right); // 中
        invertTree(root.left); // 左
        invertTree(root.right); // 右
        return root;
    }

    private void swap(TreeNode left, TreeNode right) {
        int v = left.val;
        left.val = right.val;
        right.val = v;
    }

    // 迭代法 -- 深度
    TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            swap(node.left, node.right);

            if (node.left != null) {
                st.push(node.left);
            }

            if (node.right != null) {
                st.push(node.right);
            }
        }

        return root;
    }

    // 广度
    TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                swap(node.left, node.right);
                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);

                }
            }

        }

        return root;
    }
}
