package leets;

import java.util.HashMap;
import java.util.Map;

public class leet014 {
    
    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
     * 使得 A[i] + B[j] + C[k] + D[l] = 0。
     * 
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
     * 所有整数的范围在 -2^(28) 到 2^(28)-1 之间，最终结果不会超过 2^(31)-1 。
     */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer,Integer> umap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                if ( umap.containsKey(a+b) ) {
                    umap.put(a+b, 1+umap.get(a+b));
                } else {
                    umap.put(a+b, 1);
                }
            }
        }
        int count = 0; // 统计a+b+c+d = 0 出现的次数
        // 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
        for (int c : C) {
            for (int d : D) {
                if (umap.containsKey(0 - (c + d))) {
                    count += umap.get(0 - (c + d));
                }
            }
        }
        return count;
    }
}
