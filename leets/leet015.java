package leets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class leet015 {
    
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     */

    // 哈希表法
    public int[][] threeSum(int[] nums) {
        
        int[][] res = new int[1][3];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] > 0 ) {
                continue;
            }

            if ( i > 0 && nums[i] == nums[i-1] ) {  // 去重
                continue;
            }

            Set<Integer> set = new HashSet<>();
            int k = 0;
            for (int j = i+1; j < nums.length; j++) {

                if ( j > i+2 && nums[j] == nums[j-1] && nums[j-1] == nums[j-2]) { // 去重
                    continue;
                }

                int c = 0-(nums[i]+nums[j]);
                if ( set.contains(c) ) {
                    res[k][0] = nums[i];
                    res[k][1] = nums[j];
                    res[k][2] =  c;
                    k ++;
                } else {
                    set.add(nums[j]);
                }
            }
        }

        return res;
    }

    // 双链表法
    public static Vector<Vector<Integer>> threeSum2(int[] nums) {

        Vector<Vector<Integer>> res = new Vector<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] > 0 ) {
                return res;
            }

            if ( i > 0 && nums[i] == nums[i-1] ) {
                continue;
            }

            int l = i+1;
            int r = nums.length-1;

            while ( r > l ) {

                while (r > l && nums[r] == nums[r-1]) {
                    r --;
                }
                
                while (r > l && nums[l] == nums[l+1]) {
                    l ++;
                }

                if (nums[l] + nums[i] + nums[r] > 0) {
                    r --;
                } else if ( nums[l] + nums[i] + nums[r] < 0 ) {
                    l ++;
                } else {
                    // Vector<Integer> tmp = new Vector<>(){nums[l], nums[i], nums[r]};
                    Vector<Integer> tmp = new Vector<>();
                    tmp.add(nums[l]);
                    tmp.add(nums[i]);
                    tmp.add(nums[r]);

                    res.add(tmp);
                    
                    while (r > l && nums[r] == nums[r-1]) {
                        r --;
                    }
                    
                    while (r > l && nums[l] == nums[l+1]) {
                        l ++;
                    }

                    r --;
                    l ++;

                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum2(nums);
    }

}
