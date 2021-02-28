package leets2;

import utils.ListNode;

public class leet227 {
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;

        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
