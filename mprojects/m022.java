package mprojects;

import utils.ListNode;

public class m022 {
    public ListNode getKth(ListNode head, int k ) {
        ListNode p,q;
        p = q = head;
        int size = k;
        while ( (size --) != 0 && q != null ) {
            q = q.next;
        }
        if ( size != 0 ) {
            return null;
        }
        while ( q != null ) {
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
