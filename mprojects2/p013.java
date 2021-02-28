package mprojects2;
//第K小的数
public class p013 {
    //快排思想
    public int minKth2(int[] arr, int k){
        if( arr.length < k ) {
            return -1;
        }
        return process2(arr, 0, arr.length-1, k-1);
    }

    //T(N) = O(N)+T(N/5)+T(7N/10)
    public int process2(int[] arr, int L, int R, int k) {
        if( L == R ){
            return arr[L];
        }
        //找随机排序点
        int pivot = arr[(int) (L + Math.random() * (R - L + 1))]; //pivot 支点
        // 划分范围
        int[] range = partition(arr, L, R, pivot);

        if( k >= range[0] && k <= range[1] ){
            return arr[k];
        }else if( k < range[0] ){
            return process2(arr, L, range[0]-1, pivot);
        }else{
            return process2(arr, range[1]+1, R, pivot);
        }
    }
    public int[] partition(int[] arr, int L, int R, int pivot) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while( cur < more ){
            if( arr[cur] < pivot ){
                swap(arr, ++ less, cur ++);
            }else if( arr[cur] > pivot ){
                swap(arr, cur, --more);
            }else{
                cur ++;
            }
        }
        return new int[]{ less+1, more-1 };
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //bfprt 算法
    //O(N)
    public int minKth3(int[] array, int k){
        int[] arr = copyArray(array);
        return bfprt(arr, 0, arr.length-1, k-1);
    }

    //BFPRT算法
    private int bfprt(int[] arr, int L, int R, int k) {
        if( L == R ){
            return arr[L];
        }
        int pivot = medianOfMedians(arr, L, R);
        // 划分范围
        int[] range = partition(arr, L, R, pivot);

        if( k >= range[0] && k <= range[1] ){
            return arr[k];
        }else if( k < range[0] ){
            return bfprt(arr, L, range[0]-1, pivot);
        }else{
            return bfprt(arr, range[1]+1, R, pivot);
        }
    }

    //五个数一组，每个小组内部有序，将各组中位数里的中位数返回
    private int medianOfMedians(int[] arr, int L, int R) {
        int size = R-L+1;
        int offset = size%5 == 0 ? 0:1;
        int[] mArr = new int[size/5 + offset];
        for (int team = 0; team < mArr.length; team++) {
            int teamFirst = L+team*5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(R, teamFirst+4));
        }
        return bfprt(arr, 0, mArr.length, mArr.length/2 );
    }

    private int getMedian(int[] arr, int L, int R) {
        insertionSort(arr, L, R);
        return arr[L+(R-L)/2];
    }

    public void insertionSort(int[] arr, int L, int R) {
        for (int i = L+1; i < R; i ++) {
            int temp = arr[i];
            for (int j = i; j > 0; j --) {
                if(arr[j]<arr[j-1]){
                    arr[j]=arr[j-1];
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    private int[] copyArray(int[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }
}
