package leets;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 你可以假设数组中无重复元素。
 */
public class leet001 {

    public int insertIndex(int[] nums, int target) { // nums - 升序

        // 寻找插入点
        int res = binarySearch(nums, target);

        // 返回插入点
        return res;
    }

    // 普通解法
    public int insertIndex2(int[] nums, int target) { // nums - 升序

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {

                return i;
            }

        }
        return nums.length;
    }

    // 采用 []
    public int binarySearch2(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r + 1;
    }

    // 采用 [)
    private int binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
