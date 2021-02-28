package leets;

import java.util.Arrays;

public class leet082 {
    /**
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     */
    /**
     * 局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
     */
    int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);

        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) {
                result ++;
            } else {    // 气球挨着 - 合并气球
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return result;
    }
    // 时间复杂度O(nlogn)，因为有一个快排 空间复杂度O(1)
}
