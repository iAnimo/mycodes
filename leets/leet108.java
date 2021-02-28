package leets;

import java.util.HashSet;
import java.util.Set;

public class leet108 {
    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     */
    // 回溯法 时间复杂度：O(2^n)，因为每一个单词都有两个状态，切割和不切割 空间复杂度：O(n)，算法递归系统调用栈的空间
    Set<String> wordSet = new HashSet<>();

    boolean wordBreak(String s) {
        return backtracking(s, 0);
    }

    boolean backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            return true;
        }
        for (int i = startIndex; i < s.length(); i++) {
            int endIndex = i - startIndex + 1;
            String word = s.substring(startIndex, endIndex);
            if (wordSet.contains(word) && backtracking(s, i + 1)) {
                return true;
            }
        }

        return false;
    }
}
