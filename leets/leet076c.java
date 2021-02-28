package leets;

public class leet076c {
    /**
     * 版本二:移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不考虑是不是终点的情况。
     */
    int jump(int[] nums) {
        int curDistance = 0;    // 当前覆盖的最远距离下标
        int ans = 0;            // 记录走的最大步数 
        int nextDistance = 0;   // 下一步覆盖的最远距离下标 
        for (int i = 0; i < nums.length - 1; i++) { // 注意这里是小于nums.size() - 1，这是关键所在
            nextDistance = Math.max(nums[i] + i, nextDistance); // 更新下一步覆盖的最远距离下标
            if (i == curDistance) {                 // 遇到当前覆盖的最远距离下标
                curDistance = nextDistance;         // 更新当前覆盖的最远距离下标
                ans++;
            }
        }
        return ans;
    }

}
