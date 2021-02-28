package mprojects;

import utils.TreeNode;

public class m028 {
    public boolean isSynimetrix(TreeNode root){
        if ( root == null ) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if ( left == null || right == null ) {
            return true;
        }
        if ( left == null || right == null ) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right,right.left);
    }
    
}
