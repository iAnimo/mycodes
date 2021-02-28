package leets2;

import utils.ListNode;

public class leet233 {
    // 优化空间复杂度
    // 先通过 双指针技巧汇总 中的快慢指针来找到链表的中点
    boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast != null) { // 链表为奇数串
            slow = slow.next;
        }

        // 比较回文串
        ListNode left = head;
        ListNode right = leet226.reverse(slow);

        while (right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
