package leets2;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class leet202 {
    // 找到字符串中所有字母异位词
    Vector<Integer> findAnagrams(String s, String t) {
        Vector<Integer> res = new Vector<>();
        int left = 0;
        int right = 0;
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            int val = needs.containsKey(c) ? needs.get(c)+1:1;
            needs.put(c, val);
        }

        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                int val = window.containsKey(c1) ? window.get(c1)+1:1;
                window.put(c1, val);
                if (window.get(c1) == needs.get(c1)){
                    match ++;
                }
            }
            right ++;

            while (match == needs.size()) {
                if (left - right == t.length()) {
                    res.add(left);
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    int val = window.containsKey(c2) ? window.get(c2)-1:1;
                    window.put(c2, val);
                    if (window.get(c2) < needs.get(c2)){
                        match --;
                    }
                }
                left ++;
            }
        }
        return res;
    }
}