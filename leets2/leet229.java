package leets2;

public class leet229 {
    // 寻找回文串
    String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return s.substring(l + 1, r - l -1);
    }
}
