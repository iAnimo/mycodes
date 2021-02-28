package leets;

public class leet074 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    // 暴力解法 - 第一层for 就是设置起始位置，第二层for循环遍历数组寻找最大值
    // 时间复杂度：O(n^2) 空间复杂度：O(1)
    int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                result = count > result ? count : result;
            }
        }
        return result;
    }
}
