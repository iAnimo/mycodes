package leets;

import java.util.Arrays;
import java.util.Vector;

public class leet085 {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     */
    /**
     * 排序之后局部最优：每次合并都取最大的右边界，这样就可以合并更多的区间了，整体最优：合并所有重叠的区间。
     */
    Vector<int[]> merge(int[][] intervals) {
        Vector<int[]> result = new Vector<>();
        if (intervals.length == 0) {
            return result;
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] -i2[0]);

        boolean isMerge = false;    // 最后一个区间
        int len = intervals.length;

        for (int i = 1; i < len; i++) {
            int start = intervals[i-1][0];
            int end = intervals[i-1][1];
            while (i < len && intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
                if (i == len -1) {
                    isMerge = true;
                }
                i ++;
            }
            result.add(new int[]{start, end});
        }

        if (isMerge == false) {
            result.add(new int[]{intervals[len-1][0], intervals[len-1][1]});
        }

        return result;
    }
}
