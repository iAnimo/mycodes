package mprojects;

import java.util.HashSet;
import java.util.Set;

public class m003 {
    //hash 
    public int findRepeatNumber1(int[] nums){
        Set<Integer> set =new  HashSet<Integer>();
        int res = -1;
        for(int n:nums){
            if(!set.add(n)){
                res = n;
                break;
            }
        }
        return res;
    }
    //桶装法
    public int findRepeatNumber(int[] nums){
        int n=nums.length;
        for(int num:nums)
            if(num<0 || num>=n)
                return -1;
        for(int i=0; i<n; i++ ){
            while(nums[i] != i && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            if(nums[i] != i && nums[nums[i]] == nums[i])
                return nums[i];
        }
        return -1;
    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
