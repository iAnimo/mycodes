package leets;

import java.util.Vector;

public class leet062b {
    /**
     * 把回溯的过程放在递归函数里
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
    Vector<String> result;
    void getCombinations(char[] digits, int index, String s) {
        if (index == digits.length) {
            result.add(s);
            return;
        }

        int digit = digits[index]-'0';
        char[] letters = letterMap[digit].toCharArray();
        for (int i = 0; i < letters.length; i++) {
            getCombinations(digits, index+1, s+letters[i]);
        }
    }

    Vector<String> letterCombinations(String digits) {
        result = new Vector<>();
        if (digits.length() == 0) {
            return result;
        }
        getCombinations(digits.toCharArray(), 0, "");
        return result;
    }
}
