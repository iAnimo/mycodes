package mprojects2;
import java.util.LinkedList;
import java.util.Queue;

import utils.TNode;

public class p056 {
    
    //序列化
    public Queue<String> preSerial ( TNode head ) {
        Queue<String> ans = new LinkedList<>();
        pres( head , ans ) ;
        return ans;
    }

    private void pres(TNode head, Queue<String> ans) {
        if ( head == null ) {
            ans.add( null );
        } else {
            ans.add(String.valueOf(head.value));
            pres ( head.left, ans );
            pres ( head.right, ans );
        }
    }

    //反序列
    public TNode buildByPreQueue(Queue<String> prelist){
        if ( prelist == null || prelist.size() == 0 ) {
            return null;
        }
        return preb(prelist);
    }

    private TNode preb(Queue<String> prelist) {
        String value = prelist.poll();
        if ( value == null ) {
            return null;
        }
        TNode head = new TNode(Integer.valueOf(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    //层级遍历 - 序列化
    public Queue<String> levelSerial(TNode head ){
        Queue<String> ans = new LinkedList<>();
        if ( head == null ) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<TNode> q = new LinkedList<>();
            q.add(head);
            while ( !q.isEmpty() ){
                head = q.poll();
                if ( head.left != null ) {
                    q.add(head.left);
                    ans.add(String.valueOf(head.left.value));
                } else {
                    ans.add(null);
                }
                if ( head.right != null ) {
                    q.add(head.right);
                    ans.add(String.valueOf(head.left.value));
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
    //层级遍历 - 序列化
    public TNode buildByLevelQueue(Queue<String> levelQueue){
        if ( levelQueue.isEmpty() ){
            return null;
        }
        TNode head = createTNode(levelQueue.poll());
        Queue<TNode> q = new LinkedList<>();
        if ( head != null ){
            q.add(head);
        }
        TNode node = null;
        while ( !q.isEmpty() ){
            node = q.poll();
            node.left = createTNode(levelQueue.poll());
            node.right = createTNode(levelQueue.poll());
            if ( node.left != null ) {
                q.add(node.left);
            }
            if ( node.right != null ) {
                q.add(node.right);
            }
        }
        return head;
    }
    
    public TNode createTNode(String val){
        if ( val == null ) {
            return null;
        }
        return new TNode(Integer.valueOf(val));
    }
}
