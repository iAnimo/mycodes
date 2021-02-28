package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet044c {
    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     */
    // 要遍历整个树，找到所有路径，「所以递归函数不要返回值！」
    Vector<Vector<Integer>> result = new Vector<>();
    Vector<Integer> path = new Vector<>();
    void traversal(TreeNode cur, int count) {
        if ( cur.left == null && cur.right == null && count == 0) {
            result.add(path);
            return ;
        }
        if ( cur.left == null && cur.right == null) {
            return;
        }

        if ( cur.left != null ) {
            path.add(cur.left.val);
            count -= cur.left.val;

            traversal(cur.left, count);

            count += cur.left.val;

            path.remove(path.size()-1);
        }

        if ( cur.right != null ) {
            path.add(cur.right.val);
            count -= cur.right.val;

            traversal(cur.right, count);

            count += cur.right.val;

            path.remove(path.size()-1);
        }
        return; 
    }

    Vector<Vector<Integer>> pathSum(TreeNode root, int sum) {
        result.clear();
        path.clear();

        if (root == null) {
            return result;
        }
        path.add(root.val);
        traversal(root, sum-root.val);

        return result;
    }

}
