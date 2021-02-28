package leets;

public class leet021 {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     */
    String reverseLeftWords(String str, int n) {
        char[] s = str.toCharArray();
        reverse( s, 0,  n-1);
        reverse( s, n, s.length-1);
        reverse( s , 0, s.length-1);
        return s.toString();
    }

    public void reverse(char[] s, int l, int r) {
        while ( r > l) {

            char t = s[l];
            s[l] = s[r];
            s[r] = t;

            l ++;
            r --;
        }
    }
}
