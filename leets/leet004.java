package leets;

public class leet004 {
    
    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     */

    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        int startx = 0, starty = 0; // 定义每循环一个圈的起始位置
        int loop = n / 2; // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int mid = n / 2; // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int count = 1; // 计数
        int offset = 1; // 边界
        int i,j;

        while ( loop -- > 0 ) {
            i = startx;
            j = starty;

            // 上 x,y+1
            for (j = starty; j < starty+n-offset; j++) {    // starty,starty+n-offset
                res[startx][j] = count++;
            }
            // 右 x+1,y
            for (i = startx; i < startx+n-offset; i++) {    // startx,startx+n-offset
                res[i][j] = count++;
            }
            // 下 x,y-1
            for (; j > 0; j--) {
                res[i][j] = count++;
            }

            // 左 x-1,y
            for (; i > 0; i--) {
                res[i][j] = count++;
            }

            startx ++;
            starty ++;
        }

        if ( n % 2 == 1 ) {
            res[mid][mid] = count;
        }
        return res;
    }
}
