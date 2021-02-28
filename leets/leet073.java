package leets;

public class leet073 {
    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     */
    /**
     * 「局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值」。
     * 
     * 「整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列」
     * 
     * 局部最优推出全局最优，并举不出反例，那么试试贪心！
     */
    int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];

            // 上峰路或下峰路
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result ++;
                preDiff = curDiff;
            }
        }
        return result;
    }
    // 时间复杂度O(n)，空间复杂度O(1)   
}
