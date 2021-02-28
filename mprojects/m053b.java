package mprojects;

public class m053b {
    
    public int missingNumber( int[] nums ) {
        if ( nums == null || nums.length == 0 ) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while ( l < r ) {
            int mid = l + (r - l)/2;
            if ( nums[mid] != mid ) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        //[0,1]  -- 2
        if ( nums[r] == r ) {
            r ++;
        }
        return r;
    }
}
