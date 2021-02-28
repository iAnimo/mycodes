package mprojects;

public class m029 {
    public static int[] spiralOrder(int[][] matrix) {
        if ( matrix.length == 0 ) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        int num = 0;
        int[] res = new int[(right+1)*(down+1)];
        while ( true ) {
            for (int i = left; i <= right; i++) {
                res[num++] = matrix[up][i];
            }
            if ( ++ up > down ) break;

            for (int i = up; i <= down; i++) {
                res[num++] = matrix[i][right];
            }
            if ( -- right < left ) break;

            for (int i = right; i >= left; i--) {
                res[num++] = matrix[down][i];
            }
            if ( -- down < up ) break;

            for (int i = down; i > up; i--) {
                res[num++] = matrix[i][left];
            }
            if ( ++ left > right ) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix= { 
                    {1 ,2 ,3 ,4},
                    {12,13,14,5},
                    {11,16,15,6},
                    {10,9 ,8 ,7}
                };
        
        int[] res = spiralOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]+" ");
        }
        
    }
    
}
