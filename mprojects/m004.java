package mprojects;

public class m004 {
    //二维数组中的查找
    public boolean findNumberIn2dArray(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)){
            return false;
        }
        int i=0,j=matrix[0].length-1;
        while( i<= matrix.length-1 && j>= 0 ){
            if( matrix[i][j]==target ) return true;
            if( matrix[i][j]<target ){
                i++; //往下找
            }else{
                j--; //往右找
            }
        }
        return false;
    }
}
