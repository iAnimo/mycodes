package leets;

import java.util.Arrays;

public class leet079 {
    /**
     * 有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     * 
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     * 
     * 每个孩子至少分配到 1 个糖果。 相邻的孩子中，评分高的孩子必须获得更多的糖果。
     * 
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     */

    /**
     * 局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，
     * 
     * 全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
     */
    int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);

        // 从左至右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }

        // 从右至左
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                candys[j] = Math.max(candys[j], candys[j + 1] + 1);
            }
        }


        Arrays.stream(candys).sum();
        // 统计
        int result = 0;
        for (int c : candys) {
            result += c;
        }

        return result;
    }

    /**
     * 采用了两次贪心的策略：
     * 
     * 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。 
     * 
     * 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
     */
}
