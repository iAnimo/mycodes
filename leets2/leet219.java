package leets2;

import java.util.Arrays;

public class leet219 {
    // 高效寻找素数
    // 排除法
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                for (int j = 2 * i; j < n; j++) {
                    isPrim[j] = false;
                }
            }
        }
        
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                ans ++;
            }
        }
        return ans;
    }
}
