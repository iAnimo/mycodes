package leets2;

public class leet213 {
    // 寻找左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == nums.length) {
            return -1;
        }
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }
}
