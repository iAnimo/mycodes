package leets;

public class leet009 {
    
    public static boolean isAnagram(String s, String t) {

        int[] words = new int[26];

        for (char sub : s.toCharArray()) {
            words[sub-'a'] ++;
        }

        for (char sub : t.toCharArray()) {
            words[sub-'a'] --;
        }

        for (int count : words) {
            if ( count != 0 ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("art", "tra"));
        System.out.println(isAnagram("arc", "tra"));
    }
}
