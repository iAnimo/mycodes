package leets;

import java.util.Stack;
import java.util.Vector;

import utils.TreeNode;

public class leet052c {
    /**
     * 迭代法
     */
    Vector<Integer> findMode(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur =  root;
        TreeNode pre = null;
        int maxCount = 0;
        int count = 0;
        Vector<Integer> result = new Vector<>();

        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                if (pre == null) {
                    count = 1;
                } else {
                    count ++;
                }

                if (count == maxCount) {
                    result.add(cur.val);
                }
        
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                }

                pre = cur;
                cur= cur.right;
            }
        }
        return result;
    }
}
