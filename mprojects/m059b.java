package mprojects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class m059b {
    public Queue<Integer> que;
    public Deque<Integer> deq;  //记录最大值与次大值
    
    public m059b() {
        que = new LinkedList<>();
        deq = new LinkedList<>();
    }


    public int max_value() {
        // deq 队首
        return deq.isEmpty() ? -1 : deq.peek() ;
    }

    public void push_back(int value) {
        que.add(value);
        while ( !deq.isEmpty() && deq.peekLast() < value ) {
            deq.pollLast();
        }
        deq.add(value);
    }

    public int pop_front() {
        int v = que.isEmpty() ? -1 : que.poll();

        if ( !deq.isEmpty() && deq.peekFirst() == v ) {
            deq.pollFirst();
        }

        return v;
    }

    
}
