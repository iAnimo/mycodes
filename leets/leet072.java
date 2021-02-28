package leets;

import java.util.Arrays;

public class leet072 {
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     */
    int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1;
        int result = 0;
        for (int gi = g.length - 1; gi >= 0; gi--) {
            if (si >= 0 && s[si] >= g[gi]) {
                result ++;
                si --;
            }
        }
        return result;
    }
}
