package mprojects;

public class m051 {
    public int reversePairs(int[] nums){
        int len = nums.length;
        if ( len < 2 ) return 0;
        int[] temp = new int[len];
        return mergeSort(nums, 0, len-1, temp);
    }

    private int mergeSort(int[] nums, int l, int r, int[] temp) {
        if ( l >= r ) return 0;
        int m = l + (r-l)/2;
        int lp = mergeSort(nums, l, m, temp);
        int rp = mergeSort(nums, m+1, r, temp);
        int cp = mergeSortCross(nums, l, r, m, temp);
        if ( nums[m] <= nums[m+1] ) {
            return lp + rp + cp;
        }
        return lp + rp;
    }

    private int mergeSortCross(int[] nums, int l, int r, int m, int[] temp) {
        for (int i = 0; i <= r; i++) {
            temp[i] = nums[i];
        }
        int i = l;
        int j = m+1;
        int count =  0;
        for (int k = l; k <= r; k++) {
            if ( i == m+1 ) {
                nums[k] = temp[j++];
            } else if ( j == r+1 ) {
                nums[k] = temp[i++];
            }
            if ( temp[i] <= temp[j] ) {
                nums[k] = temp[i];
                i ++;
            } else {
                nums[k] = temp[j];
                j ++;
                count  += m-i+1;
            }
        }
        return count;
    }
}
