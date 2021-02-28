
package leets;

import utils.TreeNode;

public class leet049b {
    // 迭代法
    /**
     * 因为二叉搜索树的特殊性，也就是节点的有序性，可以不使用辅助栈或者队列就可以写出迭代法
     */
    TreeNode searchBST(TreeNode root, int val) {
        while ( root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
