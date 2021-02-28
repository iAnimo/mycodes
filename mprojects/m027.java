package mprojects;

import utils.TreeNode;

public class m027 {
    public TreeNode mirrorTree(TreeNode root) {
        if ( root == null ) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
    
}
