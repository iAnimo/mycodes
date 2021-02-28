package leets;

public class leet003 {
    
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0。
     */

    public static void main(String[] args) {
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        int b = new leet003().lastLen2(nums, s);
        System.out.println(b);
    }

    // 暴力
    public int lastLen3(int[] nums, int s) {

        int result = Integer.MAX_VALUE; // 最终的结果
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    result = result < subLength ? result : subLength;
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

     // 滑动窗口
    public int lastLen2(int[] nums, int s) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 滑动窗口数值之和
        int i = 0; // 滑动窗口起始位置
        int subLength = 0; // 滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s) {
                subLength = (j - i + 1); // 取子序列的长度
                result = result < subLength ? result : subLength;
                sum -= nums[i++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }


     // 双指针
     /* public int lastLen(int[] nums, int s) {

        int left = 0;
        int right = 0;
        int res = 0;
        int size = Integer.MAX_VALUE;
        
        while( right >= nums.length-1 || left > right) {

            if ( res < s ) {
                res += nums[right];
                right ++;
                // size = size < right - left + 1 ? size: right - left + 1;
            } else {
                if ( res-nums[left] >= s ) {
                    res -= nums[left];
                    left ++;
                } else {
                    right ++;
                }
            }
        }

        return right - left + 1;
     } */
}
