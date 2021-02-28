package leets2;

import java.util.HashMap;
import java.util.Map;

public class leet203 {
    // 无重复字符的最长子串
    int lenSubString(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            int val = window.containsKey(c1) ? window.get(c1) + 1: 1;
            window.put(c1, val);
            right ++;

            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                int val2 = window.containsKey(c2) ? window.get(c2) - 1: 1;
                window.put(c2, val2); 
                left ++;
            }
            res = Math.max(res, right-left);
        }

        return res;
    }
}
