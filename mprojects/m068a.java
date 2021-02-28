package mprojects;

import utils.TNode;

public class m068a {
    
    public TNode lowestComAncestor(TNode root, TNode p, TNode q) {

        // p < root < q
        
        if (p.value > q.value ) {
            TNode t = p;
            p = q;
            q = t;
        }

        while ( root != null ) {
            if ( root.value < p.value ) {
                root = root.right;
            } else if ( root.value > q.value ) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
