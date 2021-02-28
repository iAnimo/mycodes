package leets;

import java.util.Stack;

public class leet025 {
    
    /**
     * 使用栈实现队列的下列操作： 
     * push(x) -- 将一个元素放入队列的尾部。 
     * pop() -- 从队列首部移除元素。 
     * peek() -- 返回队列首部的元素。 
     * empty() -- 返回队列是否为空。
     */
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();

    void push(int x) {
        st1.push(x);
    }

    int pop() {
        if ( st2.isEmpty() ) {
            while ( st1.isEmpty() ) {
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }

    int peek() {
        int res = this.pop();
        st2.push(res);

        return res;
    }

    boolean empty(){
        return st1.isEmpty() && st2.isEmpty();
    }
}
