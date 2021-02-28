package leets;

public class leet086b {
    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     */
    /**
     * 局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，可以保证这两位变成最大单调递增整数。
     * 
     * 全局最优：得到小于等于N的最大单调递增的整数。
     */
    int monotoneIncreasingDigits(int n) {
        String strNum = Integer.toString(n);
        int len = strNum.length();

        int[] nch = new int[len];
        for (int i = 0; i < len; i++) {
            nch[i] = strNum.charAt(i) - '0'; 
        }

        int ch9 = len;
        for (int i = ch9; i > 0; i++) {
            if (nch[i-1] > nch[i]) {
                ch9 = i;
                nch[i-1] --;
            }
        }

        for (int i = ch9; i < nch.length; i++) {
            nch[i] = 9;
        }

        return Integer.parseInt(String.valueOf(nch));
    }

    int monotoneIncreasingDigits2(int n) {
        String strNum = Integer.toString(n);
        int len = strNum.length();

        int ch9 = len;
        char[] ans = new char[len];
        for (int i = ch9-1; i > 0; i--) {
            if (strNum.charAt(i-1) > strNum.charAt(i)) {
                ch9 = i;
                ans[i-1] = (char) (strNum.charAt(i - 1) - 1);
                // strNum.charAt(i-1) -= 1 ;
            } else {
                ans[i] = strNum.charAt(i);
            }
        }

        for (int i = ch9; i < ans.length; i++) {
            ans[i] = '9';
        }

        return Integer.parseInt(String.valueOf(ans));
    }
}
