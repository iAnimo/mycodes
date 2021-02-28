package leets;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class leet002 {
    

    // 双指针
    public void delElements(int[] nums, int val) {
        
        int fasti = 0;
        int slowi = 0;

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == val ) {
                fasti ++;
            }
            fasti ++;
            slowi ++;
            swap(nums, fasti, slowi);
        }
    }

    private void swap(int[] nums, int fasti, int slowi) {
        int tmp = nums[fasti];
        nums[fasti] = nums[slowi];
        nums[slowi] = tmp;
    }

    // 原地
    public int delElements2(int[] nums, int val) {
        
        int slowi = 0;

        for (int fasti = 0; fasti < nums.length; fasti++) {
            if ( nums[fasti] != val ) {
                nums[slowi++] = nums[fasti];
            }
        }

        return slowi;
    }
}
