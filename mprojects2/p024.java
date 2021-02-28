package mprojects2;
import java.util.Queue;
import java.util.Stack;

import utils.TNode;

//list序列化
public class p024 {
    public TNode buildByPreQueue(Queue<String> prelist){
        if( prelist == null || prelist.size() == 0 ){
            return null;
        }
        return preb(prelist);
    }
    public TNode preb(Queue<String> prelist){
        String value = prelist.poll();
        if( value == null ){
            return null;
        }
        TNode head = new TNode(Integer.valueOf(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    //左右中 - 后序 
    public TNode buildByPosQueue(Queue<String> poslist){
        if( poslist == null || poslist.size() == 0 ){
            return null;
        }
        Stack<String> stack = new Stack<>();
        while ( !poslist.isEmpty() ){
            stack.push(poslist.poll());
        }
        return posb(stack);
    }
    //中右左 --> 左右中
    public TNode posb(Stack<String> posstack){
        String value = posstack.pop();
        if( value == null ){
            return null;
        }
        TNode head = new TNode(Integer.valueOf(value));
        head.right = posb(posstack);
        head.left = posb(posstack);
        return head;
    }

}
