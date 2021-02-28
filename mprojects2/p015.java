package mprojects2;
import utils.TNode;

public class p015 {
    
    // 最小树高度
    public int minHeight(TNode x){
        if( x.left == null || x.right == null ){
            return 1;
        }
        int rightBoardSize = Integer.MAX_VALUE;
        if( x.left != null ){
            rightBoardSize = minHeight(x.left);
        }
        int rightH = Integer.MAX_VALUE;
        if( x.right != null ){
            rightH = minHeight(x.right);
        }
        return 1 + Math.min(rightBoardSize, rightH);
    }
    //morris改写
    //思路
    /*
    level = 1, cur = head
        1.cur=cur.left，则level ++
        2.cur.left == null:
            level ++
        3.cur.left != null:

    */
    public int morrisHeight(TNode head) {
        if(head == null){
            return 0;
        }
        TNode cur = head;
        TNode mright = null;
        int curLevel = 0;
        int minHeight = Integer.MAX_VALUE;
        while(cur != null){
            mright = cur.left;
            if(mright != null){
                int rightBoardSize = 1; //当前节点左子树的节点数
                while(mright.right != null && mright.right != cur){ //最右节点
                    rightBoardSize ++;
                    mright = mright.right;
                }
                if(mright.right == null){ //第一次到达
                    curLevel ++;
                    mright.right = cur;
                    cur = cur.left;
                    continue;
                }else{ //第二次到达
                    if( mright.left == null ){ //当前节点左子树的最右节点无左子树 - 即叶子节点
                        minHeight = Math.min(minHeight, curLevel);
                    }
                    curLevel -= rightBoardSize;
                    mright.right = null;
                }
            }else{ //仅一次到达
                curLevel ++;
            }
            cur = cur.right;
        }
        //最后的最右叶子节点
        int finalRight = 1;
        cur = head;
        while( cur.right != null ){
            finalRight ++;
            cur = cur.right;
        }
        if( cur.left == null && cur.right == null ){
            minHeight = Math.min(minHeight, finalRight);
        }
        return minHeight;
    }
}
