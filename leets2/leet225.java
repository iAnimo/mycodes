package leets2;

import utils.ListNode;

public class leet225 {
    // 反转链表的一部分
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return new leet224().reverseN(head, n);
        }
        head.next = reverseBetween(head, m-1, n-1);
        return head;
    }
}
