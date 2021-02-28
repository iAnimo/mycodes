package leets;

import utils.TreeNode;

public class leet045 {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     */
    public static void main(String[] args) {
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 3, 15, 20, 7 };
        traversal(inorder, postorder);
    }

    // 非完整代码
    private static TreeNode traversal(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);

        if (postorder.length == 1) {
            return root;
        }

        int indx;
        for (indx = 0; indx < inorder.length; indx++) {
            if (inorder[indx] == val) {
                break;
            }
        }

        // 切分

        root.left = traversal(inorder, postorder);
        root.right = traversal(inorder, postorder);

        return root;
    }

    public static int[] inorder;
    public static int[] postorder;
    // 表索引
    private static TreeNode traversal(int indx1, int indx2, int podx1, int podx2) {
        if (podx1 == podx2) {
            return null;
        }

        int val = postorder[podx2 - 1];
        TreeNode root = new TreeNode(val);

        if (podx2 - podx1 == 1) {
            return root;
        }

        int cutIndx;
        for (cutIndx = indx1; cutIndx < indx2; cutIndx++) {
            if (inorder[cutIndx] == val) {
                break;
            }
        }

        // [)
        root.left = traversal(indx1, cutIndx, podx1, podx1+cutIndx-indx1);
        root.right = traversal(cutIndx + 1, indx2, podx1+cutIndx-indx1, podx2-1);

        return root;
    }

    TreeNode buildTree(){
        if ( inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return traversal(0, inorder.length, 0, postorder.length);
    }
}
