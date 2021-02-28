package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet031 {

    /**
     * 递归 1.确定递归函数的参数和返回值 2.确定终止条件 3.确定单层递归的逻辑
     */

    /** LeetCode
     * 144.二叉树的前序遍历 145.二叉树的后序遍历 94.二叉树的中序遍历
     */

    void traversal(TreeNode cur, Vector<Integer> vec) {
        if (cur == null) return;
        vec.add(cur.val);    // 中
        traversal(cur.left, vec);  // 左
        traversal(cur.right, vec); // 右
    }
    Vector<Integer> preorderTraversal(TreeNode root) {
        Vector<Integer> result = new Vector<>();
        traversal(root, result);
        return result;
    }
}
