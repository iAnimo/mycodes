package mprojects;

import java.util.ArrayList;
import java.util.List;

public class m057b {
    
    /**
     * target = 15
     * 
     * 1,2,3,4,5
     * 4,5,6
     * 7,8
     */

    public int[][] findSequence( int target ) {
        
        List<int[]>  res = new ArrayList<>();

        int j = 1;
        int sum = 1;
        
        for (int i = 1; i < target; i++) {

            while ( sum < target ) {
                j ++;
                sum += j;
            }

            if ( sum == target && j-i >= 1 ) {

                int[] arr = new int[j-i+1];
                for (int k = i; k <= j; k++) {
                    arr[k-i] = k;
                }

                res.add(arr);
            }

            sum -= i;   // i, j 同方向变化
        }
        return res.toArray(new int[res.size()][]);
    }
}
