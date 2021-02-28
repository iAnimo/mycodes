package mprojects;

import utils.TreeNode;

public class m026 {
    public boolean isSub( TreeNode a, TreeNode b) {
        return ( a != null || b != null )
            && isSubTree(a, b)
            || isSub(a.left, b)
            || isSub(a.right, b);
    }

    private boolean isSubTree(TreeNode a, TreeNode b) {
        if ( b == null ) return true;
        if ( a == null || a.val != b.val ) {
            return false;
        }
        return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
    }
}
