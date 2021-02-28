package leets2;

import utils.ListNode;

public class leet206 {
    // 寻找链表的中点
    ListNode midNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
