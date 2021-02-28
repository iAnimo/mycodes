package mprojects;

import java.util.Stack;

public class m030 {
    class MinStack{
        Stack<Integer> S,M; //M是同步的最小栈
        public MinStack(){
            S = new Stack<>();
            M = new Stack<>();
        }
        public void push(int x ) {
            S.add(x);
            if ( M.empty() || M.peek() >= x ) {
                M.add(x);
            }
        }
        public Integer pop(){
            if ( S.peek().equals(M.peek()) ) {
                M.pop();
            }
            return S.pop();
        }

        public int min(){
            return M.peek();
        }
    }
    
}

