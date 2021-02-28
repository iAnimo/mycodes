package leets;

public class leet076 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     */
    // 每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
    boolean canJump(int[] nums) {
        int cover = 0;  // 可覆盖范围
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+nums[i], cover);
            if (cover >= nums.length-1) {
                return true;
            }
        }

        return false;
    }
}
