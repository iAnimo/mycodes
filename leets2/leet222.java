package leets2;

import utils.ListNode;

public class leet222 {
    // 有序链表 - 删除重复元素
    ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null) {
            if (fast.value != slow.value) {
                slow = slow.next;
                slow.next = fast;
            } 
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
    
}
