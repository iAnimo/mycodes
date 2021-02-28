package leets;

import java.util.Stack;
import java.util.Vector;

import utils.TreeNode;


public class leet032 {
    /**
     * 迭代法
     */
    //前序遍历
    Vector<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Vector<Integer> res = new Vector<>();

        st.add(root);

        while ( !st.isEmpty() ) {

            TreeNode node = st.pop();   // 中
            res.add(node.val);

            if (node.right != null) {   // 右
                st.add(node.right);
            }

            if ( node.left != null ) {  // 左
                st.add(node.left);
            }

        }
        return res;
    }

    Vector<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Vector<Integer> res = new Vector<>();

        st.add(root);
        while ( !st.isEmpty() ) {
            while(st.peek().left != null ) { // 左
                st.add(st.peek().left);
            }
            TreeNode node = st.pop();   // 中
            res.add(node.val);

            if (node.right != null) {   // 右
                st.add(node.right);
            }
        }
        return res;
    }

    Vector<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Vector<Integer> res = new Vector<>();
        TreeNode cur = root;
        while ( cur != null || !st.isEmpty() ) {
            if ( cur != null ) {
                st.push(cur);
                cur = cur.left; // 左
            } else {
                cur = st.pop();
                res.add(cur.val); // 中
                cur = cur.right; // 右
            }
        }
        return res;
    }

    // 后序 ： 左右中 - - 中右左
    Vector<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Vector<Integer> res = new Vector<>();

        st.push(root);
        while ( !st.isEmpty() ){
            TreeNode node = st.pop();   // 中
            res.add(node.val);

            if (node.right != null) {   // 右
                st.add(node.right);
            }

            if ( node.left != null ) {  // 左
                st.add(node.left);
            }
        }
        int size = res.size();
        while ( size -- > 0 ) {
            res.add(res.get(size));
        }

        return res;
    }



}
