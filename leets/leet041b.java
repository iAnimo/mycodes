package leets;

import java.util.Stack;
import java.util.Vector;

import utils.TreeNode;

public class leet041b {
    
    // 迭代法
    Vector<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        StringBuilder psb = new StringBuilder();
        Vector<String> result = new Vector<>();

        if ( root == null) {
            return result;
        }

        st.push(root);
        psb.append(root.val);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            String path = psb.append(root.val).toString();
            if ( node.left == null && node.right == null) {
                result.add(path);
            }

            if ( node.right != null) {
                st.push(node.left);
                psb.append("->"+node.left.val);
            }

            if(node.left != null) {
                st.push(node.right);
                psb.append("->"+node.right.val);

            }
        }

        return result;
    }
}
