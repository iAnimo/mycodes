package leets;

import java.util.Stack;

import utils.TreeNode;
public class leet059b {
    /**
     * 迭代法:迭代法其实就是中序模板题了
     */
    int pre;

    TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    void traversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.right;
            } else {
                cur = st.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;
            }
        }
    }
}
