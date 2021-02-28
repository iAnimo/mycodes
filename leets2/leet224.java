package leets2;

import utils.ListNode;

public class leet224 {
    // 反转链表前 N 个节点

    ListNode successor = null; // 后驱节点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head, n-1);
        
        head.next.next = head;
        head.next = successor;

        return last;
    }
}