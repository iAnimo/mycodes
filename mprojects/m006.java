package mprojects;

import java.util.Stack;

import utils.ListNode;

public class m006 {
    public int[] solution1(ListNode head){
        //压栈
        Stack<Integer> stk = new Stack<Integer>();
        ListNode temp = head;
        while( temp!=null ){
            stk.push(temp.value);
            temp = temp.next;
        }
        int[] res = new int[stk.size()];
        for(int i=0; i<stk.size(); i++ ){
            res[i] = stk.pop();
        }
        return res;
    }
    public int[] solution(ListNode head){
        ListNode temp = head;
        int size = 0;
        while( temp!=null ){
            size ++;
            temp = temp.next;
        }
        int[] res = new int[size];
        temp = head;
        for(int i=size-1; i>=0; i-- ){
            res[i] = temp.value;
            temp = temp.next;
        }
        return res;
    }
}
