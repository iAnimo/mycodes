package leets;

import java.util.Vector;

import utils.TreeNode;

public class leet051 {
    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     */
    // 把二叉搜索树转换成有序数组，然后遍历一遍数组，就统计出来最小差值了
    Vector<Integer> res = new Vector<>();
    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }
    int getMini(TreeNode root) {
        res.clear();
        traversal(root);
        if (res.size() < 2) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            result = Math.min(result, res.get(i));
        }
        return result;
    }
}
