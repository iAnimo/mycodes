package mprojects;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class m009 {
    /**
     * 队列实现栈
     * 队列：先进先出
     * 栈：先进后出
     */
    class QStack{
        Queue<Integer> aQueue,bQueue;
        public QStack() {
            aQueue = new LinkedList<>(); //主
            bQueue = new LinkedList<>();
        }
        public void push(int x){
            aQueue.add(x);
        }
        public Integer peek() throws Exception {
            if ( aQueue.isEmpty() ) {
                throw new Exception("no elements");
            }
            while ( aQueue.size() != 1 ) {
                bQueue.add(aQueue.poll());
            }
            int res = bQueue.poll();

            Queue<Integer> tQueue = aQueue;
            aQueue = bQueue;
            bQueue = tQueue;
    
            return res;
        }
    }
    /**
     * 栈实现队列
     * 队列：先进先出
     * 栈：先进后出
     */
    class SQueue{
        Stack<Integer> aStack,bStack;
        public SQueue() {
            aStack = new Stack<>(); //主
            bStack = new Stack<>();
        }
        //出队
        public int poll() throws Exception {
            if ( aStack.isEmpty() && bStack.isEmpty() ) {
                throw new Exception("out of index");
            } else if ( bStack.isEmpty() ) {
                while ( aStack.size() != 1 ) {
                    bStack.add(aStack.pop());
                }
            }
            return aStack.pop();
        }
        //入
        public Integer peek() throws Exception {
            if ( aStack.isEmpty() && bStack.isEmpty() ) {
                throw new Exception("out of index");
            } else if ( bStack.isEmpty() ) {
                while ( aStack.size() != 1 ) {
                    bStack.add(aStack.pop());
                }
            }
            return aStack.pop();
        }
    }
}
