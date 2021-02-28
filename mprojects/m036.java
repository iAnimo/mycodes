package mprojects;

import utils.TNode;

public class m036 {

    public TNode pre = null;
    public TNode head = null;

    public TNode TreeToDoubleList(TNode root){
        if ( root == null ) {
            return null;
        }
        dfs(root);

        //头尾相连
        head.left = pre;
        pre.right = head;
        
        return head;
    }

    private void dfs(TNode cur) {
        if ( cur == null ) {
            return; 
        }
        dfs(cur.left);
        if ( pre != null ) {
            pre.right = cur;
        } else {
            head = cur;
        }

        cur.left = pre; pre = cur;
        
        dfs(cur.right);
    }
}
