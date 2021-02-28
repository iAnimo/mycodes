package utils;

//插入排序 O(n^2) O(n)
public class InsertionSort{
    public int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            for (int j = i; j >0 && arr[j]<arr[j-1]; j--) {
                // if(arr[j]<arr[j-1]){
                    Tools.swap(arr, j-1, j);
                // }
            }
        }
        return arr;
    }
    //改进 - 加入临时变量，去掉swap
    public int[] insertionSort2(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            int temp = arr[i];
            for (int j = i; j >0; j--) {
                if(arr[j]<arr[j-1]){
                    arr[j]=arr[j-1];
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }
        return arr;
    }
    //双插入排序 pair insertion sort
    //1.找到两个数A,B且A<B
    //2.先插入A,插入位置记为aindex
    //3.插入B时从aindex开始找寻插入点

}

