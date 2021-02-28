package leets2;

import utils.ListNode;

public class leet226 {
    // 反转整个链表 - 迭代法
    public static ListNode reverse(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != null) {

            nxt = cur.next; // 下一节点
            cur.next = pre; // 反转

            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
