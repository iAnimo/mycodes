package leets;

import java.util.Stack;

public class leet026 {
    
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */
    boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == ')' ) {
                st.push(')');
            } else if ( s.charAt(i) == '{' ) {
                st.push('}');
            } else if ( s.charAt(i) == '[' ) {
                st.push(']');
            // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
            // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
            } else if ( st.empty() || st.peek() != s.charAt(i)) {
                return false;
            } else {
                st.pop();
            }
        }
        // 第一种情况：此时我们已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，否则就return true
        return st.empty();
    }
}
