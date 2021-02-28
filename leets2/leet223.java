package leets2;

import utils.ListNode;

public class leet223 {
    // 递归反转整个链表
    ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        // 反转
        head.next.next = head;
        head.next = null;
        return last;
    }
}
