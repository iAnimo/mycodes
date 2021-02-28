package utils;

//希尔排序 - 改进的插入排序
public class ShellSort{
    public int[] shellSort_sigle(int[] arr){
        int gap = 4;
        for (int i = gap; i < arr.length-1; i++) {
            for (int j = i; j >gap-1; j-=gap) {
                if(arr[j]<arr[j-gap]){
                    Tools.swap(arr, j-gap, j);
                }
            }
        }
        return arr;
    }
    public int[] shellSort(int[] arr){
        // gap = arr.length >> 1 or arr.length/2
        // Knuth序列：h=1,h=3*h+1; - O(n^1.3)
        int h = 1;
        while( h<= arr.length-1){
            h = h*3 + 1;
        }
        for (int gap = h;gap > 0; gap=(gap-1)/3) {
            for (int i = gap; i < arr.length-1; i++) {
                for (int j = i; j >gap-1; j-=gap) {
                    if(arr[j]<arr[j-gap]){
                        Tools.swap(arr, j-gap, j);
                    }
                }
            }
        }
        return arr;
    }
}

