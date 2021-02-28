package utils;

//选择排序 O(n^2) 不稳定
public class SelectionSort{
    public int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            Tools.swap(arr, i, minPos);
        }
        return arr;
    }
}

