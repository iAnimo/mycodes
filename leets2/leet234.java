package leets2;

import utils.ListNode;

public class leet234 {
    // 这种解法虽然高效，但破坏了输入链表的原始结构，能不能避免这个瑕疵呢？
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

        boolean ans = true;

        while (right != null) {
            if (left.value != right.value) {
                ans =  false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        left.next = leet226.reverse(left.next.next);    // 恢复链表初始的状态
        return ans;
    }
}
