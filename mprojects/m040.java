package mprojects;

import java.util.Arrays;

public class m040 {
    public int[] getLeastNumbers( int[] arr, int k ) {
        if ( k == 0 || arr.length == 0 ) {
            return new int[]{};
        }
        return qsk( arr, 0, arr.length-1, k-1 );
    }

    private int[] qsk(int[] arr, int l, int r, int k) {
        int j = quickSort(arr, 1, r);
        if ( j == k ) {
            return Arrays.copyOf(arr, j+1);
        }
        return j > k ? qsk(arr, l, j-1, k) : qsk(arr, j+1, r, k);
    }

    private int quickSort(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l;
        int j = r+1;
        while ( true ) {
            while ( ++i <= r && arr[i] < v );
            while ( --j >= l && arr[i] > v );
            if ( i>j ) break;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
        arr[l] = arr[j];
        arr[j] = v;
        return j;
    }
    
}
