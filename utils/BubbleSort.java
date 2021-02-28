package utils;

//冒泡排序 O(n^2) O(n)
public class BubbleSort{
    //从后往前,正序
    public int[] bubbleSort(int[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1])
                    Tools.swap(arr, j+1, j);
            }
        }
        return arr;
    }
    //从后往前,正序
    public int[] bubbleSort2(int[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i && arr[j] > arr[j+1]; j++) {
                    Tools.swap(arr, j+1, j);
            }
        }
        return arr;
    }
}

