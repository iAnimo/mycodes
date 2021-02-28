package leets2;

import utils.ListNode;

public class leet232 {
    /* 倒序打印单链表中的元素值 */
    void traverse(ListNode head) {
        if (head == null)
            return;
        traverse(head.next);
        // 后序遍历代码
        // print(head.value);
    }
}
