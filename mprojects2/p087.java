package mprojects2;
public class p087 {
    /**
     * 素数分布定理：不大于n的素数的个数为n/log(n)
     */
    public static void main(String[] args) {
        int x = 100002;
        int N = 1500 * 1000;
        // int N = getN(x);
        byte[] a= new byte[N];
        for (int i = 2; i < N/2; i++) {
            if ( a[i] == 1 ) continue; //越过a[i] = 1的点
            for (int j = 2; j <= N/i; j++) {    //寻找i的倍数
                if ( i*j < N ) a[i*j] = 1;
            }
        }

        //赛选
        int m = 0;
        for (int i = 2; i < N; i++) {
            if ( a[i] == 0 ){
                m ++;
                if ( m == x ) System.out.println(i + " ");
            }
        }

        System.out.println("m= " + m);  //检测N
        // 1299743
        // m= 114155
    }
    public static double getN(int x) {
        double t = 100;
        while( t/Math.log(t) < x) t *= 1.1;
        // System.out.println(t);
        return t;
    }
}

