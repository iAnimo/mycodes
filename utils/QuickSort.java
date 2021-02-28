package utils;

public class QuickSort{
    //快速排序 - 传统
    // O(n*log n) , O(n^2)
    //空间：O(log n)
    public void quickSort(int[] arr, int left, int right){
        if(left>=right) return;
        int pix = partition(arr, left, right);
        quickSort(arr, left, pix-1);
        quickSort(arr, pix+1, right);
    }
    private int partition(int[] arr, int left, int right){
        int i=left;
        int j=right-1;
        int key = arr[right];
        while(i<=j){    //当仅存在两个值时，无法进入循环。此时需要使用=号
            while(i<=j && arr[i]<=key) i++;
            while(i<=j && arr[j]> key) j--; //其他相同元素放在右区
            if(i<j) Tools.swap(arr, i, j);
        }
        Tools.swap(arr, i, right);
        return i;
    }
    //双轴快排
    //1.已1/7的长度找轴（5个轴）
        //1.1若e1<e2<e3<e4<e5
            //取e2和e4
            //分区z1,z2,z3
                //z1=(<pivot1),z2=(pivot1<= && <= pivot2),z3=(>pivot2)
        //1.2否则取e3
            //取e2和e4
            //分区z1,z2,z3
                //z1=(<pivot),z2=(== pivot),z3=(>pivot)
    
}

