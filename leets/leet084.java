package leets;

import java.util.Vector;

public class leet084 {
    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     */
    Vector<Integer> partitionLabels(String s) {
        int[] chp = new int[27];
        // 统计每一个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            chp[s.charAt(i)-'a'] = i;
        }

        Vector<Integer> result = new Vector<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, chp[s.charAt(i)-'a']);
            if (i == right) {
                result.add(right-left+1);   // 返回串的长度
                left = i+1;
            }
        }

        return result;
    }
}
