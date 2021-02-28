package mprojects2;
import java.util.HashMap;
import java.util.Map;

public class p086 {
    /**
     * 问题：楼梯总共有10级，每次只能走1级或者2级，求总共有多少种走法
     */
    public static void main(String[] args) {
        System.out.println(f(10));
        Map<Integer, Integer> dic = new HashMap<>();
        System.out.println(f2(10,dic));
        System.out.println(f3(10));
    }

    //method 1
    public static int f(int n) {
        //outer
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        return f(n-1)+f(n-2);
    }
    /**
     * method 2
     * 备忘录求解
     */
    

    public static int f2(int n,Map<Integer,Integer> keys) {
        //outer
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        if ( keys.containsKey(n) ) {
            return keys.get(n);
        } else {
            int t = f2(n - 1, keys) + f2(n-2,keys);
            keys.put(n,t);
            return t;
        }
    }

    /**
     * method 3
     * 动态规划
     */
    public static int f3(int n) {
        int a = 1;
        int b = 2;
        int t ;
        for (int i = 3; i <= n; i++) {
            t = a+b;
            a = b;
            b = t;
        }
        return b;
    }

}
