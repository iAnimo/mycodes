package mprojects;

import utils.RNode;

public class m035 {
    /**
     * 1' 复制节点
     * 2' 复制random
     * 3' 分离
     */
    public RNode<Integer> copyRandomList(RNode<Integer> head) {
        if ( head == null ) return null;
        copy(head);
        copyrandom(head);
        return divide(head);
    }

    private void copyrandom(RNode<Integer> head) {
        while ( head != null ) {
            RNode<Integer> clone = head.next;
            if ( head.random != null ) {
                RNode<Integer> random = head.random;
                clone.random = random.next;
            }
            head = clone.next;
        }
    }

    private RNode<Integer> divide(RNode<Integer> head) {
        RNode<Integer> cloneHead = head.next;
        RNode<Integer> clone = cloneHead.next;
        head = head.next;
        while ( head != null ) {
            clone.next = head.next;
            head.next = head.next.next;
            clone = clone.next;
        }
        return cloneHead;
    }

    // 7 7' 7 7'
    private void copy(RNode<Integer> head) {
        while ( head != null ) {
            RNode<Integer> clone = new RNode<>(head.value);
            RNode<Integer> next = head.next;
            head.next = clone;
            clone.next = next;
            head = clone.next;
        }
    }
    
}

