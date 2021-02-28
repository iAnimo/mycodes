package mprojects2;
import utils.TNode;

public class p053 {
    public void f(TNode head){
        if ( head == null ) {
            return;
        }
        //1 先
        f ( head.left );
        //2 中
        f ( head.right );
        //3 后
    }
    /**
     * 递归序：每个节点都被访问3次
     * 先序 - 第一次访问，中序 - 第二次访问，后序 - 第三次访问
     */
}
