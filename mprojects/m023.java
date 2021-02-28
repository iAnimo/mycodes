package mprojects;

import java.util.HashSet;
import java.util.Set;

import utils.ListNode;

public class m023 {
    public ListNode entryNodeOfLoop(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while ( head != null ) {
            if ( !set.add(head) ) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode entryNodeOfLoop2(ListNode head){
        ListNode slow, fast;
        slow = fast = null;
        while ( slow != fast ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) {
                slow = head;
                while ( slow != fast ) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
