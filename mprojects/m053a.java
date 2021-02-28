package mprojects;

public class m053a {
    
    public int search(int[] nums, int target){

        if ( nums == null || nums.length == 0 ) {
            return 0;
        }

        // 二分
        int start = binarySearch(nums, target);
        int end = binarySearch(nums, target+1);

        return end - start + (nums[end] == target ? 1 : 0) ;
    }

    private int binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while ( l < r ) {
            int mid = l + (r - l) /2;
            if ( nums[mid] < target ){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
