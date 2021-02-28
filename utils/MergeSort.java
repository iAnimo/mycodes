package utils;

// 归并排序
class MergeSort{
    /*
    时间复杂度：O(n*logn)
    空间复杂度：O(n)
    */
    public void mergeSort(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid+1, right);
    }
    //合并
    private void merge(int[] arr,int leftPtr, int rightPtr,int rightBound){
        int mid = rightPtr-1;
        int[] temp = new int[rightBound-leftPtr+1];
        //三个点
        int i=leftPtr;
        int j=rightPtr;
        int k=0;
        while( i<=mid && j<=rightBound){
            temp[k++] = arr[i]<=arr[j] ? arr[i++]:arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=rightBound) temp[k++]=arr[j++];
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr+m]=temp[m];
        }
    }
    
    // TIM SORT - java对象排序
    //1. 切分
    //2. 多路归并
    //notes: if array is small , do "binarySort" with no merge.
}
    
