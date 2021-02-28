package mprojects2;
import utils.TNode;

public class p014 {
    //mirris遍历
/*流程如下：
当前节点cur，终止点cur=null
1)cur无左树，cur=cur.right
2)cur有左树，找左树最右节点mright
    a)mright.right -> null:
        mright.right = cur; cur = cur.left;
    b)mright.right -> cur:
        mright.right = null; 
3)cur = cur.right;
*/  
    public void process(TNode head) {
        if(head == null){
            return;
        }
        //1
        process(head.left);
        //2
        process(head.right);
        //3
    }
    //O(N) mirris序列
    public void morris(TNode head) {
        if(head == null){
            return ;
        }
        TNode cur = head;
        TNode mright = null;
        while(cur != null){
            mright = cur.left;
            if(mright != null){
                while(mright.right != null && mright.right != cur){ //最右节点
                    mright = mright.right;
                }
                if(mright.right == null){
                    mright.right = cur;
                    System.out.println(cur.value+" ");
                    cur = cur.left;
                    continue;
                }else{
                    mright.right = null;
                }
            }
            System.out.println(cur.value+" ");
            cur = cur.right;
        }
    }
    //morris中序序列
    public void morrisInorder(TNode head) {
        if(head == null){
            return ;
        }
        TNode cur = head;
        TNode mright = null;
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
            System.out.println(cur.value+" "); //cur向右移动时就打印
            cur = cur.right;
        }
    }
    //morris先序序列
    public void morrisPreorder(TNode head) {
        if(head == null){
            return ;
        }
        TNode cur = head;
        TNode mright = null;
        while(cur != null){
            mright = cur.left;
            if(mright != null){
                while(mright.right != null && mright.right != cur){ //最右节点
                    mright = mright.right;
                }
                if(mright.right == null){
                    mright.right = cur;
                    System.out.println(cur.value+" "); //第一次到达该节点时打印
                    cur = cur.left;
                    continue;
                }else{
                    mright.right = null;
                }
            }else{
                System.out.println(cur.value+" "); //cur节点没有左节点就打印
            }
            cur = cur.right;
        }
    }
    //morris后序序列
    public void morrisPostorder(TNode head) {
        if(head == null){
            return ;
        }
        TNode cur = head;
        TNode mright = null;
        while(cur != null){
            mright = cur.left;
            if(mright != null){
                while(mright.right != null && mright.right != cur){ //最右节点
                    mright = mright.right;
                }
                if(mright.right == null){
                    mright.right = cur;
                    System.out.println(cur.value+" ");
                    cur = cur.left;
                    continue;
                }else{
                    mright.right = null;
                    printEdge(cur.left);//第二次到达时，逆序打印
                }
            }
            cur = cur.right;
        }
        printEdge(head); //结尾后逆序打印
    }

    public void printEdge(TNode head) {
        TNode tail = reverseEdge(head);
        TNode cur = tail;
        while( cur!= null ){
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public TNode reverseEdge(TNode head) {
        TNode pre = null;
        TNode next = null;
        while( head != null ){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
