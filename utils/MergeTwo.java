package utils;

// 合并两个子序列
public class MergeTwo {
    //指定的mid合并
    public void midMerge(int[] arr, int L, int mid, int R){
        int i=L;
        int j=mid+1;
        int k=R;
        int[] temp = new int[arr.length];
        while( i<=mid && j<arr.length){
            temp[k++] = arr[i]<=arr[j] ? arr[i++]:arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(i<arr.length) temp[k++]=arr[j++];
    }
    //对半合并
    public void halfMerge(int[] arr){
        int mid = arr.length/2;
        int[] temp = new int[arr.length];
        //三个点
        int i=0;
        int j=mid+1;
        int k=0;
        while( i<=mid && j<arr.length){
            temp[k++] = arr[i]<=arr[j] ? arr[i++]:arr[j++];
            // if(arr[i] <= arr[j]){
            //     temp[k++]=arr[i++];    
            // }else{
            //     temp[k++] = arr[j++];
            // }
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(i<arr.length) temp[k++]=arr[j++];
        // return temp;
    }
}
