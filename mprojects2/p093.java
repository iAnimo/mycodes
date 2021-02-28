package mprojects2;
public class p093 {
    
    /**
     * 1.fb(n) - 从某个边缘某格开始，到与他相邻的另一个边缘格子结束
     * fb(n) = fb(n-1) * 2 
     * ----------------第一步刷 2*fa(n-1)
     * 1 2' 0 0 0 0 0 
     * e 2' 0 0 0 0 0
     * 
     * 2.fa(n) - 从某个边缘格子开始的所有情况
     * fa(n) =  2*fa(n-1) + 4*fa(n-2) + fb(n)
     *          相邻边缘   相邻边缘   最后走相邻边缘
     * ----------------1 fb(n)
     * 1 2' 0 0 0 0 0 
     * e 2' 0 0 0 0 0
     * ----------------2 第一步(2)刷 2*fa(n-1)
     * 1 0 0 0 0 0 0 
     * 2 0 0 0 0 0 0
     * ----------------3 第二步(3)刷 2*2*fa(n-2)
     * 1 2 0 0 0 0 0 
     * 3 4 0 0 0 0 0     
     * ----------------
     * 1 4 0 0 0 0 0 
     * 3 2 0 0 0 0 0
     * 
     * 3.fk(i,n) - 一共有n个格子，从中间的第i个格子为起点，任意结束
     * fk(i,n) = ( fb(i)*fa(n-i)*2 + fb(n-i+1)*fa(i-1)*2 ) * 2;
     *              先左后右            先右后左              对称
     * ----------------
     * 0 0 0 1 0 0 0 
     * 0 0 0 e 0 0 0
     * 总情况包含：
     *      从某个边缘格开始的所有情况  4*fa(n)
     *      从中间某个格子开始的所有情况    i从2到n-1求和 fk(i,n)
     */
    static long M = 1000000007;
    static long fb(int n){
        if ( n == 1 ) return 1;
        return fb(n-1)*2 % M;
    }
    static long fa(int n) {
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 6;
        return (2*fa(n-1) + 4*fa(n-2) + fb(n) )% M;
    }
    static long fk(int i, int n) {
        return ( fb(i)*fa(n-i)*2 % M + fb(n-i+1)*fa(i-1)*2 % M ) * 2 % M;
        // return fb(i)*fa(n-i)*2*4 % M;
    }
    static long f(int n) {
        if ( n == 1 ) return 2;
        long sum = fa(n) * 4 % M;
        for (int i = 2; i < n; i++) {
            sum = (sum+fk(i,n)) % M;
        }
        return sum;
    }
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            System.out.println(i+" "+f(i));
        }
    }

    //动态规划 - 用数组保存fa，fb，仅仅计算fk
}
