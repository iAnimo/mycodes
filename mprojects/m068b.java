package mprojects;

import utils.TNode;

public class m068b {
    
    public TNode lowestComAncestor(TNode root, TNode p, TNode q) {

        if( root == null  || p == null || q == null ) {
            return root;
        }

        TNode left = lowestComAncestor(root.left, p, q);
        TNode right = lowestComAncestor(root.right, p, q);

        if ( left == null ) {
            return right;
        }

        if ( right == null ) {
            return left;
        }

        return root;
    }
}
