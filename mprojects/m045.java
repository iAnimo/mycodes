package mprojects;

import java.util.Arrays;

public class m045 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        StringSort(str, 0, str.length-1);
        Arrays.sort(str, (x,y)->(x+y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }

    private void StringSort(String[] str, int l, int r) {
        if ( l>r ) return ;
        int i = l;
        int j = r;
        String temp = str[i];
        while( i<j ) {
            while ( (str[j]+str[l]).compareTo(str[l]+str[j]) > 0 && i<j ) {
                j --;
            }
            while ( (str[i]+str[l]).compareTo(str[l]+str[i]) > 0 && i<j ) {
                i ++;
            }
            temp = str[l];
            str[l] = str[j];
            str[j] = temp;
        }
        str[i] = str[l];
        str[l] = temp;
        StringSort(str, l, i-1);
        StringSort(str, i+1, r);
    }
    
}
