package leets;

public class leet023 {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */
    void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }

        int[] next = new int[s.length()];
        getNext(next, s);

        int len = s.length();
        // 字符串的长度 % (字符串的长度 - 最长公共前后缀的长度) == 0 ：有重复的子字符串
        if (next[len - 1] != -1 && len % (len - (next[len - 1] + 1)) == 0) {
            return true;
        }

        return false;
    }
}
