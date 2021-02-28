package mprojects;

import utils.ListNode;

public class m052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        ListNode indexB = headB;
        while ( indexA != indexB ) {
            if ( indexA == null ) {
                indexA = headB;
            } else {
                indexA = indexA.next;
            }

            if ( indexB == null ) {
                indexB = headA;
            } else {
                indexB = indexB.next;
            }
        }
        return indexA;
    }
    
}
