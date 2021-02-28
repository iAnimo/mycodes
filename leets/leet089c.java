package leets;

public class leet089c {
    /**
     * 递归解法
     */
    // 时间复杂度：O(2^n)
    // 空间复杂度：O(n) 算上了编程语言中实现递归的系统栈所占空间
    int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
