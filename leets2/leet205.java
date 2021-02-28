package leets2;

import utils.ListNode;

public class leet205 {
    // 已知链表中含有环，返回这个环的起始位置
    ListNode detectCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow == fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
