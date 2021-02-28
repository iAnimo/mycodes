package leets;

import java.util.Stack;

import utils.TreeNode;

public class leet042b {
    /**
     * 迭代法: 后序遍历 
     * 左右中 - 中左右
     */
    int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return 0;
        }
        st.push(root);
        int res = 0;
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }

            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return res;
    }
}
