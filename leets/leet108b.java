package leets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet108b {
    /**
     * 记忆化递归
     */
    Set<String> wordSet = new HashSet<>();
    int[] memory;

    boolean wordBreak(String s) {
        memory = new int[s.length()];
        Arrays.fill(memory, -1);    //初始值
        return backtracking(s, memory, 0);
    }

    private boolean backtracking(String s, int[] memory, int startIndex) {
        if (startIndex >= s.length()) {
            return true;
        }

        if (memory[startIndex] != -1) {
            return (memory[startIndex] == 1);
        }
        for (int i = startIndex; i < s.length(); i++) {
            int endIndex = i - startIndex + 1;
            String word = s.substring(startIndex, endIndex);
            if (wordSet.contains(word) && backtracking(s, memory, i + 1)) {
                memory[startIndex] = 1; // 可拆分
                return true;
            }
        }

        memory[startIndex] = 0; // 不可拆分
        return false;
    }
}
