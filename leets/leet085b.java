package leets;

import java.util.Arrays;
import java.util.Vector;

public class leet085b {
    /**
     * 优化代码
     */
    Vector<int[]> merge(int[][] intervals) {
        Vector<int[]> result = new Vector<>();
        if (intervals.length == 0) {
            return result;
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] -i2[0]);

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int end =  result.get(result.size()-1)[1];
            if (end >= intervals[i][0]) { // 可以合并
                end = Math.max(end, intervals[i][1]);   
            } else {
                result.add(intervals[i]);
            }
        }

        return result;
    }
}
