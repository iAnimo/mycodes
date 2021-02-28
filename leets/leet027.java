package leets;

import java.util.Stack;

public class leet027 {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
     */
    /**
     * abbaca
     * - aaca
     * - ca
     */
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ( st.empty() || s.charAt(i) != st.peek() ) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
        }

        StringBuffer res = new StringBuffer();
        while ( !st.empty() ) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}