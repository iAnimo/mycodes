package leets2;

public class leet211 {
    // 有多少个子数组的和为 k

    // O(N^2)
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1]; // 前缀和
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    ans ++;
                }
            }
        }

        return ans;
    }
}
