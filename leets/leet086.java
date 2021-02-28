package leets;

public class leet086 {
    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     */
    // 暴力解法
    int monotoneIncreasingDigits(int n) {
        for (int i = n; i > 0; i--) {
            if (checkNum(i)) {
                return i;
            }
        }
        return 0;
    }
    boolean checkNum(int num) {
        int max = 10;
        while (num > 0) {
            int t = num % 10;
            if (max >= t) {
                max = t;
            } else {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
