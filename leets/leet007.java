package leets;

import utils.ListNode;

public class leet007 {
    
    /**
     * 反转一个单链表。
     */

    // 双指针
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode t ;
        while ( cur!=null ) {
            t = cur.next;
            cur.next = pre;

            pre = cur;
            cur = t;
        }

        return pre;
    }

    // 递归解法
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if ( cur == null ) {
            return cur;
        }
        ListNode t = cur.next;
        cur.next = pre;     // cur->pre
        return reverse(cur, t);
    }
}
