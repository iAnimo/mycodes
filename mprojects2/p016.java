package mprojects2;
import utils.TNode;

public class p016 {
    //是否为线索二叉树 O(1) - 中序遍历为递增序列
    
    public boolean isBST(TNode head){ // - mirros中序
        if(head == null){
            return true;
        }
        TNode cur = head;
        TNode mright = null;
        Integer pre = null;
        while(cur != null){
            mright = cur.left;
            if(mright != null){
                while(mright.right != null && mright.right != cur){ //最右节点
                    mright = mright.right;
                }
                if(mright.right == null){
                    mright.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mright.right = null;
                }
            }
            if( pre != null && pre >= cur.value ){
                return false;
            }
            pre = cur.value;
            cur = cur.right;
        }
        return true;
    }
}
