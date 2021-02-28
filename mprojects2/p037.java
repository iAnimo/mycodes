package mprojects2;
public class p037 {
    //动态规划
    public int win2(int[] arr){
        if ( arr == null || arr.length == 0 ){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        //斜线移动
        for (int i = 1; i < N; i++) {
            int L = 0; 
            int R = i;//列
            while ( L < N && R < N ){
                f[L][R] = Math.max( //让后手吃亏 - 令先手分数最大
                            arr[L]+s[L+1][R],
                            arr[R]+s[L][R-1]
                            );
                s[L][R] = Math.min( //后手吃亏 - 先手会令后手分数变少
                            f[L+1][R],
                            f[L][R-1]
                            );
                L ++;
                R ++;
            }
        }
        return Math.max(f[0][N-1],s[0][N-1]);
    }

    public int win1(int[] arr ){
        if ( arr == null || arr.length == 0 ){
            return 0;
        }
        return Math.max(first(arr, 0, arr.length-1), second(arr, 0, arr.length-1));
    }
    public int first(int[] arr, int L, int R){
        if ( L == R ){
            return arr[L];
        }
        return Math.max( //让后手吃亏 - 令先手分数最大
                arr[L]+second(arr, L+1, R), 
                arr[R]+second(arr, L, R-1)
                );
    }
    //后手策略
    public int second(int[] arr, int L, int R){
        if ( L == R ){
            return 0;
        }
        //arr[L] or arr[R]
        return Math.min( //后手吃亏 - 先手会令后手分数变少
                first(arr, L+1, R),
                first(arr, L, R-1)
                );
    }


}
