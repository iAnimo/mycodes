package leets;

import utils.ListNode;

public class leet005 {
    
    /**
     * 删除链表中等于给定值 val 的所有节点。
     */

    // 但建议依然要养生手动清理内存的习惯。

    // 添加虚拟节点
    public ListNode removeElements(ListNode head, int val) {
        
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
       ListNode cur = dummyHead;

       while ( cur.next != null ) {
        // 1 找到位置
        if ( cur.next.value == val ) { 
            // 2 删除
               cur.next = cur.next.next;
           } else {
               cur  = cur.next;
           }
       }

       return dummyHead.next;
    }

    // 无虚拟节点
    public ListNode removeElements2(ListNode head, int val) {

        // 1 删除第一个节点
        while ( head != null && head.value == val ) {
            head = head.next;
        }

        // 2 删除后续
       ListNode cur = head;
       while ( cur != null && cur.next != null ) {
           if ( cur.next.value == val ) {
               cur.next = cur.next.next;
           } else {
               cur = cur.next;
           }
       }
        
       return head;
    }
}
