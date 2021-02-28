package leets;

import java.util.LinkedList;
import java.util.Queue;

public class leet024 {

    
    /**
     * 使用队列实现栈的下列操作：
     * 
     * push(x) -- 元素 x 入栈 
     * pop() -- 移除栈顶元素 
     * top() -- 获取栈顶元素 
     * empty() -- 返回栈是否为空
     */
    public Queue<Integer> que1 = new LinkedList<Integer>();
    public Queue<Integer> que2 = new LinkedList<Integer>();

    public void push(int x) {
        que1.add(x);
    }

    int pop() {
        int size = que1.size();
        size--;
        while (size-- > 0) {
            que2.add(que1.poll());
        }

        int res = que1.poll();
        que1 = que2;

        while (!que2.isEmpty()) {
            que2.poll();
        }

        return res;
    }

    int top() {
        return que1.peek();
    }

    boolean empty() {
        return que1.isEmpty();
    }

}
