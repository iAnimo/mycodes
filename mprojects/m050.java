package mprojects;

import java.util.HashMap;

public class m050 {
    public char firstUniqChar(String s){
        HashMap<Character, Boolean> hash = new HashMap<>();
        char[] ch = s.toCharArray();
        for (Character c : ch) {
            hash.put(c, hash.containsKey(c));
        }
        for (char c : ch) {
            if ( hash.get(c)) {
                return c;
            }
        }
        return '.';
    }
}
