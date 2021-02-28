package mprojects2;
import java.util.Stack;

import utils.TNode;

public class p054 {
    /**
     * 先序：中左右
     * 先压入右，再压入左
     */
    public void pre( TNode head ) {
        System.out.println("pre-order:");
        if ( head != null ){
            Stack<TNode> s = new Stack<>();
            s.add(head);
            while ( !s.isEmpty() ){
                head = s.pop();
                System.out.println(head.value + " ");
                if ( head.left != null ) {
                    s.push(head.left);
                }
                if ( head.right != null ){
                    s.push(head.right);
                }
            }
        }
    }
    /**
     * 后序：左右中 -> 中左右
     * 先压入左，再压入右
     */
    public void post( TNode head ){
        System.out.println("post-order:");
        if ( head != null ){
            Stack<TNode> s = new Stack<>();
            Stack<TNode> res = new Stack<>();
            s.add(head);
            while ( !s.isEmpty() ){
                head = s.pop();
                res.add(head);
                if ( head.right != null ){
                    s.push(head.right);
                }
                if ( head.left != null ) {
                    s.push(head.left);
                }
            }
            while ( !res.isEmpty() ){
                head = res.pop();
                System.out.println(head.value + " ");
            }
        }
    }
    /**
     * 用一个栈完成后序遍历
     * 左右中
     * 1.用h标记上一个处理过的节点，c用于对树进行遍历
     * 2.情况
     *  1)    当前访问节点c的左树未处理完毕：c.left != null && h != c.left && h != c.right
     *  2)    当前访问节点c的右树未处理完毕：c.right != null && h != c.right
     *  3)    当前访问节点c的左右树都处理完毕：s.pop(); h = c;
     *  
     */
    public void post2 ( TNode h ) {
        System.out.println("post-order:");
        if ( h != null ){
            Stack<TNode> s = new Stack<>();
            s.add(h);
            while ( !s.isEmpty() ){
                TNode c = s.peek();
                if ( c.left != null && h != c.left && h != c.right) {
                    s.push(c.left);
                } else if ( c.right != null && h != c.right ) {
                    s.push(c.right);
                } else {
                    System.out.println(s.pop().value + " ");
                    h = c;
                }
            }
        }
    }
    /**
     * 中序：左中右
     * 1.左边界依次入栈
     * 2.条件1不满足时，弹出，并转向 右子树
     * 3.右子树继续执行条件1
     */
    public void in ( TNode head ) {
        System.out.println("post-order:");
        if ( head != null ){
            Stack<TNode> s = new Stack<>();
            while ( !s.isEmpty() || head != null ) {
                if ( head != null ) {
                    s.push(head);
                    head = head.left;
                } else {
                    head = s.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }
}
