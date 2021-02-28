package mprojects;

import utils.TNode;

public class m007 {
    int pindex = 0;
    int oindex = 0;
    public TNode solution(int[] preorder, int[] inorder) { //前序+中序
        //树 递归
        return dfs(preorder, inorder, null);
    }

    private TNode dfs(int[] preorder, int[] inorder, TNode node) {
        //结束条件
        if( pindex == preorder.length || (node!=null && inorder[oindex] == node.value) )
            return null;

        TNode root = new TNode(preorder[pindex++]); //根节点
        root.right = dfs(preorder, inorder, root);
        oindex ++;
        root.left = dfs(preorder, inorder, node);
        return root;
    }    
}
