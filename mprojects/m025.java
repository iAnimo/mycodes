package mprojects;

import utils.ListNode;

public class m025 {
    public ListNode mergicTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( l1 != null && l2 != null ) {
            if ( l1.value <= l2.value ) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if ( l1 != null ) {   cur.next = l1;  }
        if ( l2 != null ) {   cur.next = l2;  }
        
        return dummy.next;
    }
}
