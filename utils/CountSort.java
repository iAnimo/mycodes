package utils;

//计数排序 - 非比较排序
public class CountSort{
    //时间空间：O(n+k)
    public int[] countSort(int[] arr){
        int[] res = new int[arr.length];
        int[] count = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }

        //遍历count
        for (int i = 0,j=0; i < count.length; i++) {
            while(count[i]-- > 0) res[j++]=i;
        }
        return res;
    }
    // 案例 数据范围100-150,降低空间范围
    public int[] countSort2(int[] arr,int leftBound){
        int[] res = new int[arr.length];
        int[] count = new int[arr.length-leftBound+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-leftBound] ++; //149-100 = 49 即 0-100,49-149
        }

        //遍历count
        for (int i = 0,j=0; i < count.length; i++) {
            while(count[i]-- > 0) res[j++]=i;
        }
        return res;
    }
    //案例 变成稳定的数组
    public int[] countSort3(int[] arr){
        int[] res = new int[arr.length];
        int[] count = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }
        // 累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        //遍历count - 逆向
        for (int i = count.length; i >= 0 ; i--) {
            //index = count[arr[i]]
            res[--count[arr[i]]] = arr[i];
        }
        return res;
    }
}

