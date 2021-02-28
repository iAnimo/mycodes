package leets;

public class leet076b {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     */
    /**
     * 版本一:移动下标达到了当前覆盖的最远距离下标时，步数就要加一，来增加覆盖距离。最后的步数就是最少步数。
     */

    int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖
        int curDistance = 0;
        int nextDistance = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance); // 更新下一步覆盖最远距离下标
            if (i == curDistance) { // 遇到当前覆盖最远距离下标
                if (curDistance != nums.length - 1) { // 如果当前覆盖最远距离下标不是终点
                    result++; // 需要走下一步
                    curDistance = nextDistance; // 更新当前覆盖最远距离下标（相当于加油了）
                    if (nextDistance >= nums.length - 1) {
                        break; // 下一步的覆盖范围已经可以达到终点，结束循环
                    }
                } else {
                    break; // 当前覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
                }
            }
        }

        return result;
    }
}
