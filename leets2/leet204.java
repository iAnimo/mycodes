package leets2;

import utils.ListNode;

public class leet204 {
    // 判定链表中是否含有环
    boolean hasCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
