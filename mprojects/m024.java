package mprojects;

import utils.ListNode;

public class m024 {
    //头插法
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while ( cur != null ) {
            cur.next =pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    //递归解法
    public ListNode reverseList2(ListNode head){
        if ( head == null || head.next == null  ) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
