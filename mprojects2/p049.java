package mprojects2;
import utils.TNode;

public class p049 {
    /*
       二叉树递归套路
        1.假设以X节点为头，假设可以向X左树和X右树要任何信息
        2.在上一步的假设下，讨论以X为头节点的树，得到答案的可能性（最重要）
        3.列出所有可能性后，确定到底需要向左树和右树要什么样的信息
        4.把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
        5.递归函数都返回S，每一棵子树都这么要求
        6.写代码，在代码中考虑如何把左树的信息和右树信息整合出整棵的信息
     */
    //案例：平衡二叉树
    /**
     * 答案的可能性：
     * 左树信息：左树平衡
     * 右树信息：右树平衡
     * 条件：左右树高度差不大于1
     */
    class Info{ //信息
        public boolean isBalanced;
        public int height;
        public Info(boolean b, int h){
            isBalanced = b;
            height = h;
        }
    }
    
    public boolean isBalanced(TNode head) {
        return process2(head).isBalanced;
    }
    public Info process2(TNode X){ //返回信息
        if ( X == null ) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);
        int diff = Math.abs(leftInfo.height - rightInfo.height);
        
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isBalanced = true;
        
        if ( !leftInfo.isBalanced || !rightInfo.isBalanced || diff > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced,height);
    }
}
