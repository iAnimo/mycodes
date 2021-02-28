package mprojects;

import utils.TNode;

public class m055a {
    
    public int maxDepth(TNode root) {

        if ( root == null ) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left+1 : right+1;
    }
}
