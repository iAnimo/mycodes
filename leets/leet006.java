package leets;

import utils.ListNode;

public class leet006 {
    /**
     * 在链表类中实现这些功能： 
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */

    public class MyLinkedList{
        private ListNode dummyHead;
        private int size;

        public MyLinkedList() {
            dummyHead = new ListNode(0); // 这里定义的头结点 是一个虚拟头结点，而不是真正的链表头结点
            size = 0;
        }

        public int get(int index) {

            // 边界
            if ( index > size -1 && index < 0 ) {
                return -1;
            }
            
            ListNode cur = dummyHead;
            while ( index -- > 0 ) {
                cur = cur.next;
            }

            return cur.value;
        }

        // 插入头
        public void addAtHead(int val) {
            ListNode t = new ListNode(val);
            t.next = dummyHead.next;
            dummyHead.next = t;
            
            size ++;
        }

        // 插入尾
        public void addAtTail(int val) {
            ListNode t = new ListNode(val);
            ListNode cur = dummyHead.next;
            while ( cur.next != null ) {
                cur = cur.next;
            }
            cur.next = t;
            size ++;
        }


        // 插入值
        public void addAtIndex(int index,int val) {
            if ( index > size ) {
                return;
            }
            ListNode cur = dummyHead;
            // 1 找到插入位置
            while ( index -- > 0 ) {
                cur = cur.next;
            }
            // 2 放入
            cur.next = new ListNode(val);
            size ++;
        }

        // 删除值
        public void deleteAtIndex(int index) {
            if ( index < 0 && index > size ) {
                return;
            }

            ListNode cur = dummyHead;
            while ( index -- > 0 ) {
                cur = cur.next;
            }

            cur.next = cur.next.next;
            size --;
        }
    }
     
}
