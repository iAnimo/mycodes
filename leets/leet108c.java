package leets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet108c {
    /**
     * 背包问题
     */
    Set<String> wordSet = new HashSet<>();  // 题目给出

    boolean wordBreak(String s) {
        // step 1: dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length() + 1];
        // step 3: dp[0] = true 其他为false
        Arrays.fill(dp, false);
        dp[0] = true;

        // step 4: 本题最终要求的是是否都出现过，所以对出现单词集合里的元素是组合还是排列，并不在意！
        for (int i = 1; i <= s.length(); i++) { // 背包
            for (int j = 0; j < i; j++) { // 物品
                // step 2: 递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true
                String word = s.substring(j, i - j);
                if (wordSet.contains(word) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
