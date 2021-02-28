package mprojects;

import java.util.HashMap;

public class m048 {
    public int longestSubString(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( hash.containsKey(c) ) {
                left += Math.max(left, hash.get(c)+1);
            }
            hash.put(c, i);
            res = Math.max(res, i-left+1);
            
        }
        return res;
    }
}
