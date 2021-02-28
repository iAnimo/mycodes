package mprojects2;

public class p030 {
    /**
     * A,B玩家分别从arr中最左或最右拿牌，返回优胜者
     * 零和博弈（zero-sum game），又称零和游戏，与非零和博弈相对，
     * 是博弈论的一个概念，属非合作博弈。
     */
    //范围模型
    public int win1(int[] arr ){
        if ( arr == null || arr.length == 0 ){
            return 0;
        }
        return Math.max(first(arr, 0, arr.length-1), second(arr, 0, arr.length-1));
    }
     //先手策略
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
     /**
      * { 4,7,9,5 }
      * A:4 9 win
      * B:7 5
      */
}
