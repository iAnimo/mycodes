package utils;

import java.util.Deque;
import java.util.LinkedList;

public class MDeque {
    Deque<Integer> que;

    public MDeque() {
        this.que = new LinkedList<>();
    }

    public void pop(int value) {
        if (!que.isEmpty() && value == que.peekFirst()) {
            que.pollFirst();
        }
    }

    public void push(int value) {
        while ( !que.isEmpty() && value > que.peekLast() ) {
            que.pollLast();
        }
        que.addLast(value);
    }

    public int peekFirst() {
        return que.peekFirst();
    }
    
}
