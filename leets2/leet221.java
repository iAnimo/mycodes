package leets2;

public class leet221 {
    // 删除重复元素

    // 双指针法
    int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow ++;
                nums[slow] = nums[fast];
            } 
            fast ++;

        }

        return slow + 1;
    }
}
