package utils;

import java.util.Arrays;
import java.util.Collections;

public class BasketSort {
    // 桶排序
    int MAXLEN = 20; // 桶的最大容量

    public int[] basketSort(Integer[] arr, int baskNum) {
        int[] res = new int[arr.length];
        int[][] basket = new int[baskNum][MAXLEN]; //此处使用2分桶
        // 1.分桶
        //1.1取得最大值与最小值
        int max = (int) Collections.max(Arrays.asList(arr));
        int min =(int) Collections.min(Arrays.asList(arr));
        //1.2对区域进行划分,并进行分桶操作
        int step = (max-min)/baskNum;
        int[] divides = new int[baskNum+1]; //分区点
        divides[0]=min;divides[baskNum]=max;
        for (int i = 1; i < baskNum-1; i++) {
            divides[i]=divides[i-1]+step;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= divides.length; j++) {
                if(divides[j-1]<arr[i] && arr[i]>divides[j]){
                    int k = basket[j-1].length; //桶中数据的个数
                    basket[j-1][k] = arr[i];
                }
            }
        }
        //2.桶内排序
        //3.桶的顺序输出
        int k=0;
        for (int i = 0; i < basket.length; i++) {
            for (int j = 0; j < basket[i].length; j++) {
                res[k++] = basket[i][j];
            }
        }
        return res;
    }
}

