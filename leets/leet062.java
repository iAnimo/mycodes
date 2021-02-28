package leets;

import java.util.Vector;

public class leet062 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */

    String letterMap[] = new String[] {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };

    Vector<Vector<Character>> result;
    Vector<Character> s;
    void backtracking(char[] digits, int index) {
        if (index == digits.length) {
            result.add(s);
            return;
        }

        int digit = digits[index]-'0';
        char[] letters = letterMap[digit].toCharArray();

        for (int i = 0; i < letters.length; i++) {
            s.add(letters[i]);
            backtracking(digits, index+1);
            s.remove(letters[i]);
        }
        
    }

    Vector<Vector<Character>> letterCombinations(String digits) {
        s = new Vector<>();
        result = new Vector<>();
        if (digits.length() == 0) {
            return result;
        }
        backtracking(digits.toCharArray(), 0);
        return result;
    }
}
