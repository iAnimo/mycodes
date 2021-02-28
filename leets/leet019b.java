package leets;

public class leet019b {
    
    void reverse(String str, int start, int end) {
        char[] s = str.toCharArray();
        int offset = (end - start + 1) / 2;
        for (int i = start, j = end; i < start + offset; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            // swap(s[i], s[j]);
        }
    }
    

    String reverseStr(String s, int k) {
        for (int i = 0; i < s.length(); i += (2 * k)) {
            // 1. 每隔 2k 个字符的前 k 个字符进行反转
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= s.length()) {
                reverse(s, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
            reverse(s, i, s.length() - 1);  // []
        }
        return s;
    }
}
