package leets2;

import java.util.HashMap;
import java.util.Map;

public class leet201 {
    // 最小覆盖子串
    String minWindow(String s, String t) {

        // 记录子串起始位置与长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // 子串长度 - 起始与结束
        int left = 0;
        int right = 0;

        // 记录窗口与需求
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        // 初始化
        for (Character c : t.toCharArray()) {
            int val = needs.containsKey(c) ? needs.get(c) + 1 : 1;
            needs.put(c, val);
        }

        // 匹配数量
        int match = 0;

        // 匹配至字符串末尾，则结束
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) { // 出现匹配项
                int val = window.containsKey(c1) ? window.get(c1) + 1 : 1;
                window.put(c1, val);    // 更新匹配状态
                if (needs.get(c1) == window.get(c1)) { // 数量匹配成功
                    match++; // 匹配数量加1
                }
            }
            right++;    // 增加范围

            // 匹配成功时，对其缩小范围
            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left; // 记录当前开始位置
                    minLen = right - left; // 记录最小范围
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) { // 出现匹配项
                    int val = window.containsKey(c2) ? window.get(c2) - 1 : 1;
                    window.put(c2, val);    // 更新匹配状态
                    if (window.get(c2) < needs.get(c2)) { // 数量匹配项缺失
                        match--; // 匹配数量减少1
                    }
                }
                left++; // 缩小范围
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}