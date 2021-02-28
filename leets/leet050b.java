package leets;

import java.util.Stack;

import utils.TreeNode;

public class leet050b {
    /**
     * 迭代法 - 用迭代法模拟二叉树中序遍历
     */
    boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while ( cur != null || !st.isEmpty() ) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left; // 左
            } else {
                cur = st.pop(); // 中
                if ( pre != null && pre.val >= cur.val ) {
                    return false;
                }
                pre = cur;
                
                cur = cur.right;    // 右
            }
        }
        return true;
    }

}
