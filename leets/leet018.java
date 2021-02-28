package leets;

import java.util.Arrays;

public class leet018 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */

    public String replaceSpace(String str) {
        char[] s = str.toCharArray();
        int count = 0; // 统计空格的个数
        int sOldSize = s.length;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"%20"之后的大小
        char[] cs = Arrays.copyOf(s, s.length + count * 2);

        int sNewSize = cs.length;
        // 从后先前将空格替换为"%20"
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; i--, j--) {
            if (cs[j] != ' ') {
                cs[i] = cs[j];
            } else {
                cs[i] = '0';
                cs[i - 1] = '2';
                cs[i - 2] = '%';
                i -= 2;
            }
        }
        return cs.toString();
    }
}
