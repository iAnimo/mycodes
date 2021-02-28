package mprojects;

import utils.TNode;

public class m054 {

    // 中序
    int k1, res;
    
    public int kthNode( TNode root, int k )  {

        k1 = k;
        dfs( root );
        return res;
    }

    private void dfs(TNode root) {

        if ( root == null || k1 == 0 ) {
            return;
        }

        dfs ( root.right ) ;

        if ( --k1 == 0 ) {
            res = root.value;
        }

        dfs ( root.left ) ;

    }
}
