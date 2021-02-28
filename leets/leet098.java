package leets;

public class leet098 {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 
     * 物品是nums[i]，重量是nums[i]i，价值也是nums[i]，背包体积是sum/2。
     */
    boolean canPartition(int[] nums) {
        int sum = 0;
        // dp[i]表示 背包总容量是i，最大可以凑成i的子集总和为dp[i]。
        int[] dp = new int[20001];

        // Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) { // 奇数
            return false;
        }

        int target = sum / 2;
 
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j++) {
                // 01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[target] == target) {
            return true;
        }

        return false;
    }
    /**
     * 只有确定了如下四点，才能把01背包问题套到本题上来。
     * 
     * 背包的体积为sum / 2
     * 
     * 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
     * 
     * 背包如何正好装满，说明找到了总和为 sum / 2 的子集。
     * 
     * 背包中每一个元素是不可重复放入。
     */
}
