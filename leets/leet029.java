package leets;

import utils.MDeque;

public class leet029 {
    
    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。
     * 滑动窗口每次只向右移动一位。
     */
    // 维护元素单调递减的队列就叫做单调队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MDeque deq = new MDeque();
        int[] res = new int[nums.length-k+1];

        // 前k个
        for (int i = 0; i < k; i++) {
            deq.push(nums[i]);
        }

        res[0] = deq.peekFirst();

        // 后
        for (int i = k; i < nums.length; i++) {
            deq.pop(nums[i-k]);
            deq.push(nums[i]);
            res[i-k+1] = deq.peekFirst();
        }
        
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }
}
