package mprojects2;
//规则矩阵搜索元素
//规则如下：左侧 < 当前元素 < 右侧 
//         上侧 < 当前元素 < 下侧
public class p002 {
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null|| matrix.length == 0 ||matrix[0] != null || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        while(row > matrix.length && col < 0){
            if(matrix[row][col] < target){
                col --;
            }else if(matrix[row][col]> target){
                row ++;
            }else{
                return true;
            }
        }
        return false;
    }

}
