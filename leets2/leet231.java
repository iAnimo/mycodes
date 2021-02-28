package leets2;

import utils.ListNode;

public class leet231 {
    // 判断回文单链表
    ListNode left;
    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next); // 向下递归

        res = res && (right.value == left.value);   // 匹配

        left = left.next;   // 匹配下一个位置

        return res;
    }
}
