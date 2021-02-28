package mprojects;

import utils.ListNode;

public class m018 {
    public ListNode deleteNode(ListNode head, int val){
        ListNode pre,cur;
        pre = null;
        cur = head;

        if ( cur.value == val && pre == null ) {
            head = null;
        }
        while ( cur.value != val && cur != null ) {
            pre = cur;
            cur = cur.next;
        }
        if ( cur != null ) {
            pre.next = cur.next;
        }

        return head;
    }

    //加入一个头指针
    public ListNode deleteNode2(ListNode head, int val){
        ListNode thead = new ListNode(0,head);
        ListNode pre = thead;

        while ( head.value != val && head != null ) {
            pre = head;
            head = head.next;
        }
        if ( head != null ) {
            pre.next = head.next;
        }

        return thead.next;
    }
}
