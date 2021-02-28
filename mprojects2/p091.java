package mprojects2;
import java.util.HashMap;
import java.util.Map;

public class p091 {
    //缓存法
    static Map<Integer,Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();    //获取开始时间
        System.out.println(f(55));
        long endTime = System.nanoTime();    //获取结束时间
        System.out.println(endTime-startTime);

        startTime = System.nanoTime();
        map.put(0, true);
        System.out.println(f2(55));
        endTime = System.nanoTime();
        System.out.println(endTime-startTime);

        int N = 55;
        boolean[] dp = new boolean[N+1];
        startTime = System.nanoTime();
        System.out.println(f3(N, dp));
        endTime = System.nanoTime();
        System.out.println(endTime-startTime);

        dp = new boolean[N+1];
        startTime = System.nanoTime();
        System.out.println(f4(N, dp));
        endTime = System.nanoTime();
        System.out.println(endTime-startTime);

    }

    private static boolean f3(int n, boolean[] dp) {
        if ( dp[n] == true ) return dp[n]; //对方取走了球

        boolean t = false;
        if ( n>=1 && dp[n-1]==false ) t = true;
        if ( n>=3 && dp[n-3]==false ) t = true;
        if ( n>=7 && dp[n-7]==false ) t = true;
        if ( n>=8 && dp[n-8]==false ) t = true;

        dp[n] = t;
        return false;
    }

    private static boolean f4(int n, boolean[] dp) {
        if ( dp[n] == true ) return dp[n]; //对方取走了球

        if ( n>=1 && dp[n-1]==false ) {
            dp[n] = true;
            return true;
        }
        if ( n>=3 && dp[n-3]==false ) {
            dp[n] = true;
            return true;
        }
        if ( n>=7 && dp[n-7]==false ) {
            dp[n] = true;
            return true;
        }
        if ( n>=8 && dp[n-8]==false ) {
            dp[n] = true;
            return true;
        }
        
        dp[n] = false;
        return false;
    }

    private static boolean f(int n) {
        if ( n == 0 ) return true; //对方取走了球

        if ( n>=1 && f(n-1)==false ) return true;
        if ( n>=3 && f(n-3)==false ) return true;
        if ( n>=7 && f(n-7)==false ) return true;
        if ( n>=8 && f(n-8)==false ) return true;

        return false;
    }

    private static boolean f2(int n) {
        if ( map.get(n) != null ) return map.get(n); //对方取走了球

        if ( n>=1 && map.get(n-1) != null && map.get(n-1)==false ) {
            map.put(n,true);
            return true;
        }
        if ( n>=3 && map.get(n-3) != null && map.get(n-3)==false ) {
            map.put(n,true);
            return true;
        }
        if ( n>=7 && map.get(n-7) != null && map.get(n-7)==false ) {
            map.put(n,true);
            return true;
        }
        if ( n>=8 && map.get(n-8) != null && map.get(n-8)==false ) {
            map.put(n,true);
            return true;
        }
        
        map.put(n,false);
        return false;
    }
}
