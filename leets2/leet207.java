package leets2;

import utils.ListNode;

public class leet207 {
    // 寻找链表的倒数第 k 个元素
    ListNode kthNode(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
