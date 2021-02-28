package leets;

import utils.TreeNode;

public class leet051b {
    //  在递归中如何记录前一个节点的指针
    int result = Integer.MAX_VALUE;
    TreeNode pre;
    void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(result, cur.val-pre.val);
        }
        pre = cur;
        traversal(cur.right);
    }
    int getMinimumDifference(TreeNode root){
        traversal(root);
        return result;
    }
}
