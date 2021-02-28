package leets;

import java.util.Stack;

public class leet028 {

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的运算符包括 + , - , * , / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     */

    int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int num1 = Integer.parseInt(st.pop());
                int num2 = Integer.parseInt(st.pop());
                int res = 0;
                if (tokens[i] == "+") res = num2 + num1;
                if (tokens[i] == "-") res = num2 - num1;
                if (tokens[i] == "*") res = num2 * num1;
                if (tokens[i] == "/") res = num2 / num1;
                st.push(res+"");
            } else {
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.pop());
    }

    public static void main(String[] args) {
        System.out.println("-");
    }
}
