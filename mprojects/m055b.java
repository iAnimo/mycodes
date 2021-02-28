package mprojects;

import utils.TNode;

public class m055b {
    
    public boolean isBalance(TNode root) {

        if ( root == null ) {
            return true;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return ((Math.abs(left-right) > 1) ? false : true ) && isBalance(root.left) && isBalance(root.right);
    }

    public int treeDepth(TNode root) {

        if ( root == null ) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? left+1 : right+1;
    }
}
