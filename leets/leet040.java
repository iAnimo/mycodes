package leets;

import java.util.Stack;

import utils.TreeNode;

public class leet040 {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     */
    // 求深度可以从上到下去查 所以需要前序遍历（中左右），而高度只能从下到上去查，所以只能后序遍历（左右中）

    // 递归
    boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    // 中左右
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = getDepth(root.left);
        if (leftD == -1) {
            return -1;
        }
        int rightD = getDepth(root.right);
        if (rightD == -1) {
            return -1;
        }
        return Math.abs(leftD - rightD) > 1 ? -1 : 1 + Math.max(leftD, rightD);
    }

    // 迭代 - 用栈来模拟前序遍历
    boolean isBalanced2(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return true;
        }
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            int dep = Math.abs(getHigh(node.left) - getHigh(node.right));
            if (dep > 1) {
                return false;
            }

            if ( node.left != null ) {
                st.push(node.left);
            } 
            if ( node.right != null){
                st.push(node.right);
            }
        }
        return true;
    }

    // 中右左 - 左右中
    private int getHigh(TreeNode cur) {
        Stack<TreeNode> st = new Stack<>();
        if (cur == null) {
            return 0;
        }
        st.push(cur);
        int res = 0;
        int high = 0;
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if ( node != null){
                st.pop();
                st.push(node);// 中
                st.push(null);
                high ++;
                if ( node.right != null){   // 右
                    st.push(node.right);
                }
                if ( node.left != null ) { // 左
                    st.push(node.left);
                } 
            } else {
                st.pop();   // 空节点
                node = st.pop();
                high --;
            }
            res = res > high ? res : high;
        }
        return res;
    }

}
