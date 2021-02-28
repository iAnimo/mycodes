package leets;

import java.util.Vector;

public class leet065 {
    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     */
    Vector<String> result = new Vector<>(); // 用来存放符合条件结果

    Vector<String> restoreIpAddresses(String s) {
        result.clear();
        backtracking(s, 0, 0);
        return result;
    }
        
    void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isVaild(s.toCharArray(), startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isVaild(s.toCharArray(), startIndex, i)) {
                s += '.';
                pointNum++;
                backtracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, s.lastIndexOf("."));
            } else {
                break;
            }
        }
    }

    /**
     * 主要考虑到如下三点：
     * 
     * 段位以0为开头的数字不合法 
     * 段位里有非正整数字符不合法 
     * 段位如果大于255了不合法
     */
    private boolean isVaild(char[] s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s[start] == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s[i] > '9' || s[i] < '0') {
                return false;
            }

            num = num*10 + (s[i] - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

}
