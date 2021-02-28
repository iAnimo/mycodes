package mprojects2;
//KMP
// str1 是否为 str2 的旋转词
public class p010 {
    //棋盘上的马从(0,0)出发，有k步要走（必须走完），求最后总来到(x,y)的位置的方法数
    public int ways1(int x, int y, int k){
        return f(x,y,k);
    }

    private int f(int x, int y, int k) {
        if( k == 0 ){
            return x == 0 && y == 0 ? 1:0;
        }
        if( x < 0 || x > 9 || y < 0 || y > 8 ){

            return 0;
        }
        return f(x+2,y-1,k-1) + f(x+2,y+1,k-1) + 
               f(x-2,y-1,k-1) + f(x-2,y+1,k-1) + 
               f(x+1,y-2,k-1) + f(x+1,y+2,k-1) + 
               f(x-1,y-2,k-1) + f(x-1,y+2,k-1) ;
    }
    
    //动态规划
    public int ways2(int x, int y, int k) {
        int[][][] dp = new int[10][9][k+1];
        dp[0][0][0] = 1; //dp[..][..][0] = 0
        for (int level = 0; level <= k; level++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][level] = getValue(dp,x+2,y-1,level-1) + getValue(dp,x+2,y+1,level-1)  
                                    + getValue(dp,x-2,y-1,level-1) + getValue(dp,x-2,y+1,level-1)
                                    + getValue(dp,x+1,y-2,level-1) + getValue(dp,x+1,y+2,level-1)
                                    + getValue(dp,x-1,y-2,level-1) + getValue(dp,x-1,y+2,level-1);
                }
            }
        }
        return dp[x][y][k];
    }

    private int getValue(int[][][] dp, int x, int y, int k) {
        if( x < 0 || x > 9 || y < 0 || y > 8 ){
            return 0;
        }
        return dp[x][y][k];
    }

    //另一种方式
    public int ways3(int x, int y, int k){
        return p(0,0,k,x,y);
    }

    private int p(int i, int j, int rest, int x, int y) {
        if( rest == 0 ){
            return i == x && j == y ? 1:0;
        }
        if( i < 0 || i > 9 || j < 0 || j > 8 ){
            return 0;
        }
        return p(i+2,j-1,rest-1,x,y) + p(i+2,j+1,rest-1,x,y) + 
               p(i-2,j-1,rest-1,x,y) + p(i-2,j+1,rest-1,x,y) + 
               p(i+1,j-2,rest-1,x,y) + p(i+1,j+2,rest-1,x,y) + 
               p(i-1,j-2,rest-1,x,y) + p(i-1,j+2,rest-1,x,y) ;
    }
}
