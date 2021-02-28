package leets;

import java.util.Arrays;

public class leet083 {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     */
    /**
     * 右边界排序之后，局部最优：优先选右边界小的区间，所以从左向右遍历，留给下一个区间的空间大一些，从而尽量避免交叉。全局最优：选取最多的非交叉区间。
     */
    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (p1, p2) -> p1[1] - p2[1]);

        int count = 1;
        int end = intervals[0][1];  // 分割点
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count ++;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3} };
        eraseOverlapIntervals(intervals);
    }
}
