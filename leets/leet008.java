package leets;

import utils.ListNode;

public class leet008 {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     */

     // 双指针
     public ListNode detectCycle(ListNode head) {
         
        ListNode fast;
        ListNode slow;
        fast = slow = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if ( slow == fast ) {
                slow = head;
                while ( slow != fast ) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
     }
}
