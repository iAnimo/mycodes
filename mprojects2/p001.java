package mprojects2;

import java.util.ArrayList;
import java.util.List;

//task:矩阵中找最长拥有最长1的列
/* 
example
input:
[
    00001111
    00111111
    01111111
    01111111
]
ouput: {2,3}
*/
public class p001 {
    public static List<Integer> longestOnes2(int[][] matrix){//右上-> 左下
        //边界
        if(matrix == null|| matrix.length == 0 ||matrix[0] != null || matrix[0].length == 0){
            return null;
        }
        int N = matrix.length; //行
        int M = matrix[0].length;//列
        List<Integer> ans = new ArrayList<>();
        int maxlen = 0;
        int col = M;
        for (int i = 0; i < N; i++) {
            while(col > 0 && matrix[i][col-1] == 1){
                col --;
            }
            if(maxlen<M-col){
                maxlen = M-col;
                ans.clear();
            }
            if(matrix[i][col] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    public static List<Integer> longestOnes3(int[][] matrix){ //二分
        //边界
        if(matrix == null|| matrix.length == 0 ||matrix[0] != null || matrix[0].length == 0){
            return null;
        }
        int N = matrix.length; //行
        int M = matrix[0].length;//列
        List<Integer> ans = new ArrayList<>();
        int maxlen = 0;
        for (int i = 0; i < N; i++) {
            int j = mostleftOne(matrix[i],0,M-1);
            if(maxlen<M-j){
                maxlen = M-j;
                ans.clear();
            }
            if(maxlen == M-j){
                ans.add(i);
            }
        }
        return ans;
    }

    private static int mostleftOne(int[] arr, int left, int right) {
        int ans = right+1; //初始值位置
        int mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(arr[mid] == 1){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    //优化的是常数项
    public static List<Integer> longestOnes4(int[][] matrix){
        //边界
        if(matrix == null|| matrix.length == 0 ||matrix[0] != null || matrix[0].length == 0){
            return null;
        }
        int N = matrix.length; //行
        int M = matrix[0].length;//列
        List<Integer> ans = new ArrayList<>();
        int maxlen = 0;
        int col = M;
        for (int i = 0; i < N; i++) {
            col = mostleftOne(matrix[i], 0, col-1);//仅在左侧二分
            if(maxlen<M-col){
                maxlen = M-col;
                ans.clear();
            }
            if(matrix[i][col] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
}
