package mprojects2;

import java.util.Scanner;
import java.util.Vector;

public class p099 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] ss = scan.nextLine().trim().split(" ");
        int m = Integer.parseInt(ss[0]);
        int n = Integer.parseInt(ss[1]);

        // List[] gr = new Vector<>(m+1);
        // List[] gr = new List[m+1];
        Vector<Vector<Integer>> gr = new Vector<>(m+1);
        // List<Object> gr2 = new ArrayList<>();
        int[][] re = new int[m+1][4];

        for (int i = 0; i < n; i++) {
            ss = scan.nextLine().trim().split(" ");
            Integer v1 = Integer.parseInt(ss[0]);
            Integer v2 = Integer.parseInt(ss[1]);
            gr.get(v1).add(v2);
            gr.get(v2).add(v1);
            
            /* gr[v1].add(v2);
            gr[v2].add(v1); */
        }

        ss = scan.nextLine().trim().split(" ");
        int va = Integer.parseInt(ss[0]);
        int vb = Integer.parseInt(ss[1]);

        re[va][0] = 1;
        re[va][1] = 0;
        re[va][2] = 0;
        re[va][3] = 0;

        dfs(gr,re,va,vb);

        System.out.println(solve( re,va,vb ));

        scan.close();
    }

    private static int solve(int[][] re, int va, int vb) {
        int sum = 0;
        int p = vb;
        int min = re[p][3];
        while( true ) {
            int pa = re[p][2];
            // System.out.println("pa "+ pa);
            if ( pa == 0 || pa == va ) break;
            if ( re[pa][1] <= min ) sum ++;     //还未越过割点
            if ( re[pa][3] < min ) min = re[pa][3]; //更新min
            p = pa;
        }
        return sum;
    }

    /**
     * 
     * @param gr 图 - 数组结构，每个数组连接一个list
     * @param re 遍历后的结果
     * @param va 节点a - 开始点
     * @param vb 节点b - 结束点
     */
    private static void dfs(Vector<Vector<Integer>> gr, int[][] re, int va, int vb) {
        if ( va == vb ) return;

        for ( Object obj : gr.get(va) ) {
            int it = (Integer) obj;
            if ( re[it][0] > 0 ) {
                ancestors( re, va, re[it][1] ); //返祖
                continue;
            }

            re[va][0] = 1;  //访问标识符号
            re[va][1] = re[va][1]+1; //深度
            re[va][2] = va; //父亲节点
            re[va][3] = re[va][1]; //返祖值(深度)

            dfs( gr, re, it, vb );

        }
    }

    /**
     * 返祖
     * @param re 节点信息
     * @param v   目标节点
     * @param goal 返祖的目标
     */
    private static void ancestors(int[][] re, int v, int goal) {
        if ( re[v][3] <= goal ) return;     //越过低级的祖先
        re[v][3] = goal;
        ancestors(re, re[v][2], goal);
    }
}
