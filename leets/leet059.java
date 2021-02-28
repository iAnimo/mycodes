package leets;

import utils.TreeNode;

public class leet059 {
    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
     * 请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * 
     * 从树中可以看出累加的顺序是右中左，所以我们需要反中序遍历这个二叉树，然后顺序累加就可以了
     */
    int pre; // 记录前一个节点的数值
    void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }

    TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }
}
