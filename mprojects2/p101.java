package mprojects2;
import java.util.Scanner;

public class p101 {
    static int[] tb;   //用数组表示植物
    static int num; //记录合根的植物
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] ss = scan.nextLine().trim().split(" +");
        int M = Integer.parseInt(ss[0]);
        int N = Integer.parseInt(ss[1]);

        tb = new int[M*N+1];
        int K = Integer.parseInt(scan.nextLine().trim());
        for (int i = 0; i < K; i++) {
            ss = scan.nextLine().trim().split(" +");
            f ( Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
        }

        System.out.println(M*N-num);

        scan.close();
    }

    private static void f(int a, int b) {   //a,b 联通
        int ra = find(a);
        int rb = find(b);
        if ( ra == rb ) return ;
        union( ra, rb );
        num ++;
    }

    private static void union(int ra, int rb) {
        tb[rb] = ra; //ra作为父节点
    }

    private static int find(int x) {
        if ( tb[x] == 0 ) return x;
        return tb[x] = find(tb[x]);
    }
}
