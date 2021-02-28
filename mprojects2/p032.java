package mprojects2;

public class p032 {
    /** N皇后
     * N:0-3 无解
     * N=4 2
     */
    public int nQueen(int n){
        if( n < 3 ){
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }
    public int process1(int i, int[] record, int n){
        if ( i == n ){
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { //尝试 0~n-1 位置
            if( isValid(record, i, j) ){
                record[i] = j;
                res += process1(i+1, record, n);
                //可以不要还原现场，因为record[i]被直接赋值
            }
        }
        return res;
    }

    /**
     * record[a] = b
     * (a,b) - (c,d)
     * 共列： b=d
     * 共斜线: |a-c| = |b-d|
     */

    //从前往后放，即检查当前record[i]是否与record[0..i-1]冲突
    public boolean isValid(int[] record, int i, int j) { 
        //record[i] = j --> record[k]
        for (int k = 0; k < i; k++) {
            if ( j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k) ){
                return false;
            }
        }
        return true;
    }
    public int nQueen2(int n){
        if ( n < 1 || n > 32 ){
            return 0;
        }
        int limit = ( n == 32 ) ? -1:(1<<n) - 1; //第一位为0，其他位为1
        return process2(limit, 0, 0, 0);
    }
    //优化常数项 - 位运算
    //列限制，左右斜线限制
    public int process2(int limit, int coli, int lefti, int righti){
        if ( coli == limit ){ //行 - 列 位置都摆放完 - basecase
            return 1;
        }
        int pos = limit & ( ~(coli | lefti | righti) ); //左截无效位
        int mostRightOne = 0;
        int res = 0;
        while ( pos != 0 ){
            mostRightOne = pos & (~pos + 1); //提取最右侧的1
            pos = pos - mostRightOne;
            res += process2(limit
                            , coli | mostRightOne
                            , (lefti | mostRightOne) << 1   //左移一位，左斜线
                            , (righti | mostRightOne) >>> 1 //右移一位，右斜线
                            );
        }
        return res;
    }
}
