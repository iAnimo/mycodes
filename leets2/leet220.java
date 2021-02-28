package leets2;

import java.util.Arrays;

public class leet220 {
    // 排除法优化
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {   // 遍历次数降低logN
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {    // 重复点剔除
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }
}
