package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet041 {

    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     */
    // 递归
    Vector<String> binaryTreePaths(TreeNode root) {
        Vector<String> result = new Vector<>();
        Vector<Integer> path = new Vector<>();
        if (root == null) {
            return result;
        }
        traversal(root, path, result);
        return result;
    }

    void traversal(TreeNode cur, Vector<Integer> path, Vector<String> result) {

        path.add(cur.val);

        if (cur.left == null && cur.right == null) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                res.append(path.get(i) + "->");
            }
            res.append(path.get(path.size() - 1));
            result.add(res.toString());
            return;
        }
        // 回溯要和递归永远在一起
        if (cur.left != null) {
            traversal(cur.left, path, result);
            path.remove(path.size() - 1);
        }

        if (cur.right != null) {
            traversal(cur.right, path, result);
            path.remove(path.size() - 1);
        }

    }

    // 精简
    void traversal2(TreeNode cur, StringBuilder path, Vector<String> result) {
        path.append(cur.val);
        if ( cur.left == null && cur.right == null){
            result.add(path.toString());
            return;
        }
        if ( cur.left != null ) {
            traversal2(cur.left, path.append("->"), result);    // 回溯有问题
        }
        if ( cur.right != null ) {
            traversal2(cur.right, path.append("->"), result);
        }
    }

}
