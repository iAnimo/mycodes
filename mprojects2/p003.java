package mprojects2;
//0处延生
/*example
input:
[
    70123
    21344
    12303
    12455
]
output:
[
    00000
    20304
    00000
    10405
]
*/
public class p003 {
    //思路1：使用两个列表记录row和col的"零点"
    //思路2：
        //首先使用两个标志符，记录0行和0列是否为"零点"
        //使用0行和0列作为标志串，记录记录当前列和行是否为"零点"
    public static void setZeros1(int[][] matrix) {
        boolean row0Zero = false; // 行
        boolean col0Zero = false; // 列
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                row0Zero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                col0Zero = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if( matrix[i][j] == 0 ){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //置零
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if( matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        if( row0Zero ){ //0行
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if( col0Zero ){ // 0列
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    //改进 - 只使用一个标志量
    public static void setZeros2(int[][] matrix) {
        boolean col0Zero = false; // 列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if( matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    if( j == 0 ){
                        col0Zero = true;
                    }else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        //置零
        //从底部开始
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                if( matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        if( col0Zero ){ // 0列
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
