package leets;

import utils.TreeNode;

public class leet046 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。preorder
     */
    public static int[] inorder = new int[] {9,3,15,20,7};
    public static int[] preorder = new int[] {3,9,20,15,7};

    public static TreeNode traversal(int indx1, int indx2, int predx1, int predx2) {
        if (predx1 == predx2) {
            return null;
        }

        int val = preorder[predx1];
        TreeNode root = new TreeNode(val);

        if (predx2 - predx1 == 1) {
            return root;
        }

        int cutIndx;
        for (cutIndx = indx1; cutIndx < indx2; cutIndx++) {
            if (inorder[cutIndx] == val) {
                break;
            }
        }

        // [)
        root.left = traversal(indx1, cutIndx, predx1+1, predx1+1+cutIndx-indx1);
        root.right = traversal(cutIndx + 1, indx2, predx1+1+cutIndx-indx1, predx2);

        return root;
    }

    TreeNode buildTree(){
        if ( inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        return traversal(0, inorder.length, 0, preorder.length);
    }
}
