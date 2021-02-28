package leets;

import java.util.Stack;

import utils.TreeNode;

public class leet051c {
    // 迭代
    int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        while (cur != null || !st.isEmpty()){
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                if (pre != null) {
                    result = Math.min(result, cur.val-pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}
