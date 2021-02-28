package utils;

public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int v){
        value = v;
        next = null;
    }
    public ListNode(int v,ListNode n){
        value = v;
        next = n;
    }
}
