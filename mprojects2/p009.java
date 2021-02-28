package mprojects2;
/*
arr: 3<=n<=10^4
规则：n<=200时
1)arr[0]<=arr[1]
2)arr[n-1]<=arr[n-2]
3)arr[i]<=max{arr[i-1],arr[i-2]}

丢失位置为0
*/  
public class p009 {
    //arr[0...i] arr[i].val = v; s = (arr[i] - arr[i+1]); --> arr[i-1]
    int MAX = 200;
    public int ways(int[] arr) {
        int N = arr.length;
        if( arr[N-1] != 0 ){
            return process(arr, N-1, arr[N-1], 2);
        }else{
            int ways = 0;
            for (int v = 0; v < MAX; v++) {
                ways += process(arr, N-1, v, 2);
            }
            return ways;
        }
    }

    private int process(int[] arr, int i, int v, int s) {
        //base case
        if( i==0 ){
            // arr[0]<=arr[1]: s=0 or s=1;
            // arr[i]=0 or v = arr[i]: 
                // 当前值丢失，则可以填写任意v
                // 当前值未丢失，则判断当前值与v相等
            return (( s==0 || s==1 )&&(arr[i] == 0 || v == arr[i] )) ? 1:0 ;
        }
        if( arr[i] != 0 && v != arr[i] ){
            return 0;
        }
        //可变部分changeable case
        int ways = 0;
        if( s == 0 || s == 1 ){
            for (int pre = 1; pre < 201; pre++) {
                int next_s = ( pre < v ? 0:( pre == v ? 1:2 ) ); //三元判断
                ways += process(arr, i-1, pre, next_s);
            }
        }else{
            for (int pre = v; pre < 201; pre++) {
                int next_s = ( pre < v ? 0:( pre == v ? 1:2 ) ); //三元判断
                ways += process(arr, i-1, pre, next_s);
            }
        }
        return ways;
    }
    //动态规划解法
    public int ways2(int[] arr) {
        int N = arr.length;
        int[][][] dp = new int[N][201][3];// [][][] - i,v,s
        if( arr[0] != 0){
            dp[0][arr[0]][0] = 1;
            dp[0][arr[0]][1] = 1;
        }else{
            for (int v = 1; v < 201; v++) {
                dp[0][v][0] = 1;
                dp[0][v][1] = 1;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int v = 1; v < 201; v++) {
                for (int s = 0; s < 3; s++) {
                    if( arr[i] == 0 || v == arr[i] ){
                        if( s == 0 || s == 1 ){
                            for (int pre = 1; pre < 201; pre++) {
                                int next_s = ( pre < v ? 0:( pre == v ? 1:2 ) );
                                dp[i][v][s] += dp[i-1][pre][next_s];
                            }
                        }else{
                            for (int pre = 1; pre < 201; pre++) {
                                int next_s = ( pre < v ? 0:( pre == v ? 1:2 ) );
                                dp[i][v][s] += dp[i-1][pre][next_s];
                            }
                        }
                    }
                }
            }
        }
        if( arr[N-1] != 0 ){
            return dp[N-1][arr[N-1]][2];
        }else{
            int ways = 0;
            for (int v = 1; v < 201; v++) {
                ways += dp[N-1][v][2];
            }
            return ways;
        }
    }
    //动态规划 - 改进
    public int ways3(int[] arr) {
        int N = arr.length;
        int[][][] dp = new int[N][201][3];// [][][] - i,v,s
        if( arr[0] != 0){
            dp[0][arr[0]][0] = 1;
            dp[0][arr[0]][1] = 1;
        }else{
            for (int v = 1; v < 201; v++) {
                dp[0][v][0] = 1;
                dp[0][v][1] = 1;
            }
        }
        int[][] presum = new int[201][3];
        for (int v = 1; v < 201; v++) {
            for (int s = 0; s < 3; s++) {
                presum[v][s] = presum[v-1][s] + dp[0][v][s];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int v = 1; v < 201; v++) {
                for (int s = 0; s < 3; s++) {
                    if( arr[i] == 0 || v == arr[i] ){
                        if( s == 0 || s == 1 ){
                            dp[i][v][s] += sum(1,v-1,0,presum);
                            dp[i][v][s] += dp[i-1][v][1];
                            dp[i][v][s] += sum(v+1,200,2,presum);
                        }else{
                            dp[i][v][s] += dp[i-1][v][1];
                            dp[i][v][s] += sum(v+1,200,2,presum);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private int sum(int i, int j, int k, int[][] presum) {
        return 0;
    }
}
