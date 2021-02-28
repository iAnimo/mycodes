package mprojects2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class p100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());
        int[][] data = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] ss = scan.nextLine().trim().split(" +");
            data[i] = new int[4];
            for (int j = 0; j < 4; j++) {
                data[i][j] = Integer.parseInt(ss[j]);
            }
        }

        System.out.println( solve(data) );
        scan.close();
    }

    private static int solve(int[][] data) {
        Vector<int[]> lst = new Vector<>();
        for (int i = 0; i < data.length; i++) {
            int x1 = data[i][0];
            int y1 = data[i][1];
            int x2 = data[i][2];
            int y2 = data[i][3];

            if ( x1 == x2 || y1 == y2 ) continue;   //非法
            if ( x1 > x2 ) { int t = x1; x1=x2; x2=t; }
            if ( y1 > y2 ) { int t = y1; y1=y2; y2=t; }

            int[] a = new int[4];
            a[0] = y1;
            a[1] = y2;
            a[2] = x1;
            a[3] = 1;   //起始边

            int[] b = new int[4];
            b[0] = y1;
            b[1] = y2;
            b[2] = x2;
            b[3] = 2;   //结束边

            lst.add(a);
            lst.add(b);
        }

        Collections.sort(lst, (o1, o2) -> o1[2] - o2[2]);
        /* Collections.sort(lst, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				return ((int[])o1)[2] - ((int[])o2)[2];
			}
            
        }); */

        return work( lst );
    }

    private static int work(Vector<int[]> lst) {
        if ( lst.size() == 0 ) return 0;

        final int N = 1024 * 16;
        int[][] tr = new int[2*N][2];   //自身覆盖次数，子孙覆盖总宽度

        int[] a =  (int[]) lst.get(0);
        int from = a[2];

        add ( tr, 0, 0, N, a[0], a[1] );

        int sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            int[] it = (int[]) lst.get(i);
            if ( it[2] > from ) {
                sum += tr[0][1] * (it[2]-from);
                from = it[2];
            }
            if ( it[3] == 1 ) {
                add ( tr, 0, 0, N, it[0], it[1] );
            } else {
                del ( tr, 0, 0, N, it[0], it[1] );
            }
        }
        return sum;
    }

    private static void del(int[][] tr, int i, int a, int b, int y1, int y2) {
        if ( a == y1 && b == y2 && tr[i][0] > 0 ) {
            tr[i][0] --;
            if ( tr[i][0] == 0 ) {
                padd ( tr, (i-1)/2, tr[i][1] - (b-a) );
            }
            return;
        }

        int h = (a+b)/2;
        if ( y2 <= h ) {
            del ( tr, i*2+1, a, h, y1, y2 );
            return;
        }

        if ( y1 >= h ) {
            del ( tr, i*2+2, h, b, y1, y2 );
            return;
        }

        del ( tr, i*2+1, a, h, y1, h );
        del ( tr, i*2+2, h, b, h, y2 );
    }

    /**
     * 
     * @param tr
     * @param i  起始坐标
     * @param a  跨度
     * @param b
     * @param y1 线段
     * @param y2
     */
    private static void add(int[][] tr, int i, int a, int b, int y1, int y2) {
        if ( a == y1 && b == y2 ) {
            tr[i][0] ++;
            if ( tr[i][0] == 1 ) {
                padd ( tr, (i-1)/2, (b-a)-tr[i][1] );
            } 
            return ;
        }

        //切割
        int h = (a+b)/2;
        if ( y2 < h ) {
            add ( tr, i*2+1, a, h, y1, y2 );
            return;
        }

        if ( y1 >= h ) {
            add ( tr, i*2+2, h, b, y1, y2 );
            return;
        }

        add ( tr, i*2+1, a, h, y1, h );
        add ( tr, i*2+2, h, b, h, y2 );
    }

    private static void padd(int[][] tr, int i, int d) {
        if ( d == 0 ) return;
        tr[i][1] += d;
        if ( tr[i][0] == 0 && i > 0 ) {
            padd( tr, (i-1)/2, d);
        }
    }
}
