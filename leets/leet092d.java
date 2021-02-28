package leets;

public class leet092d {
    /**
     * 数论方法
     */
    
    /**
     * 分析
     * 
     * 无论怎么走，走到终点都需要 m + n - 2 步。
     * 在这m + n - 2 步中，一定有 m - 1 步是要向下走的，不用管什么时候向下走。
     * 
     * 结果就是求组合数 C_(m+n-2)^(m-1)
     */
    int uniquePaths(int m, int n) {
        int numerator = 1;
        int denominator = 1;
        int count = m - 1;
        int t = m + n - 2;

        // 结果会溢出
        while (count -- > 0) {
            numerator *= (t--);
        }

        for (int i = 1; i <= m - 1; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }

    // 在计算分子的时候，不断除以分母，可以解决溢出问题
    long uniquePaths2(int m, int n) {
        long numerator = 1;         // 分子
        int denominator = m - 1;    // 分母
        int count = m - 1;
        int t = m + n - 2;

        while (count -- > 0) {
            numerator *= (t --) ;
            while (denominator != 0 && numerator % denominator == 0) {
                numerator /= denominator;
                denominator --;
            }
        }

        return numerator;
    }
    
}
