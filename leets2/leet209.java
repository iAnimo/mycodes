package leets2;

public class leet209 {
    // 两数之和
    int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if(sum > target) {
                right --;
            } else {
                left ++;
            }
        }
        return new int[]{-1, -1};
    }
}
