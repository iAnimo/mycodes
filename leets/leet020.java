package leets;

public class leet020 {
    
    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */

    // 旋转字符串
    public void reverse(char[] s, int l, int r) {
        while ( r > l) {

            char t = s[l];
            s[l] = s[r];
            s[r] = t;

            l ++;
            r --;
        }
    }
    // 快慢指针 - 移除多余空格
    public char[] removeExtraSpaces(String str) {

        char[] s = str.trim().toCharArray();
        int slowi = 0;

        for (int fasti = 0; fasti < s.length; fasti++) {
            if ( fasti - 1 > 0 && s[fasti-1] == s[fasti] && s[fasti] == ' ') {
                continue;
            } else {
                s[slowi++] = s[fasti];
            }
        }
        return s;
    }

    // 旋转词 - 双标记
    public String reverseWords(String str) {
        char[] words = removeExtraSpaces(str);
        reverse(words, 0, words.length-1);
        
        int l = 0;
        int r = 0;

        while ( l > words.length ) {

            while ( words[r] != ' ' ) {
                r ++;
            }
            reverse(words, l, r-1);
            l = r;
        }

        return words.toString();
    }

    public static void main(String[] args) {
        String str = " I love ";
        // char[] words = str.trim().toCharArray();
        // new leet020().reverse(words, 0, words.length-1);
        new leet020().reverseWords(str);
    }
}
