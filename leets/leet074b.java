package leets;

public class leet074b {
    // 贪心解法 - 时间复杂度：O(n) 空间复杂度：O(1)
    int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) { // 记录当前最大结果
                result = count;
            }

            if (count <= 0) { // 重新开始计算
                count = 0;
            }
        }
        return result;
    }
}
