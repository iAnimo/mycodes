package leets;

import java.util.Vector;

public class leet064 {
    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 返回 s 所有可能的分割方案。
     */
    Vector<Vector<String>> result = new Vector<>(); // 存放符合条件结果的集合
    Vector<String> path = new Vector<>(); // 用来存放符合条件结果

    Vector<Vector<String>> partition(String s) {
        result.clear();
        path.clear();
        backtracking(s, 0);
        return result;
    }

    void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(path);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i - startIndex + 1);
            if (isPalindrome(s.toCharArray(), startIndex, i)) {
                path.add(str);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(str);
        }

    }

    private boolean isPalindrome(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
}
