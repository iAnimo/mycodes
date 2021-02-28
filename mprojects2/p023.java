package mprojects2;
import java.util.LinkedList;
import java.util.Queue;

import utils.TNode;

public class p023 {

    //中左右
    public  Queue<String> preSerial(TNode head){
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    public void pres(TNode head, Queue<String> ans){
        if(head == null){
            ans.add(null);
        }else{
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    //左中右 - 中序
    /* 
    中序序列化有问题
    [null, 1, null, 2, null] 
         2  or  1
        /        \
       1          2
    */
    public void ins(TNode head, Queue<String> ans){
        if( head == null ){
            ans.add(null);
        }else{
            ins(head.left, ans);
            ans.add(String.valueOf(head.value));
            ins(head.right, ans);
        }
    }

    //左右中
    public Queue<String> posSerial(TNode head){
        Queue<String> ans = new LinkedList<>();
        poss(head, ans);
        return ans;
    }
    public void poss(TNode head, Queue<String> ans){
        if( head == null ){
            ans.add(null);
        }else{
            ins(head.left, ans);
            ins(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }
}
