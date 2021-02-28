package utils;

import java.util.Arrays;

//基数排序 - 非比较排序
public class BaseSort{
    //有低位优先LSD和高位优先MSD两种
    //空间O(n),时间O(n*k)
    public int[] baseSort(int[] arr,int baselen){ //baselen是数的最大字符长度
        int[] res = new int[arr.length];
        int[] count = new int[10]; //0-9

        for (int i = 0; i < baselen; i++) {
            int division=(int)Math.pow(10, i); //取位点
            //countSort();
            for (int j = 0; j < count.length; j++) {
                int num = (arr[j]/division)%10;
                count[num]++;
            }
            //累加数组
            for (int j = 1; j < count.length; j++) {
                count[j]=count[j]+count[j-1];
            }
            //逆序遍历
            for (int j = arr.length; j >= 0; j--) {
                int num=(arr[j]/division)%10;
                res[--count[num]]=arr[j];
            }
            //清空，执行下一次
            System.arraycopy(res, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
        return arr;
    }
}
