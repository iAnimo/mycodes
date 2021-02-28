package leets;

import utils.TreeNode;

public class leet056 {
    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key
     * 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     */
    // 递归
    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
            if (root.left == null)
                return root.right;
            // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            else if (root.right == null)
                return root.left;
            // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            // 并返回删除节点右孩子为新的根节点。
            else {
                TreeNode cur = root.right; // 找右子树最左面的节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left; // 把要删除的节点（root）左子树放在cur的左孩子的位置
                return root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 用普通二叉树的思路来删 遍历整棵树），用交换值的操作来删除目标节点。
     */
    TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            int t = root.val;
            root.val = cur.val;
            cur.val = t;
        }

        root.left = deleteNode2(root.left, key);
        root.right = deleteNode2(root.right, key);

        return root;
    }
    /**
     * 代码中目标节点（要删除的节点）被操作了两次：
     * 第一次是和目标节点的右子树最左面节点交换。 第二次直接被NULL覆盖了。
     */
}
