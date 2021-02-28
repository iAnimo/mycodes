package mprojects2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p102 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine().trim();
        String s2 = scan.nextLine().trim();

        Set<String> from = new HashSet<>();
        Set<String> visit = new HashSet<>();

        from.add(s1);
        visit.addAll(from);

        System.out.println( bfs( visit, from, s2 ) );

        scan.close();
    }

    private static int bfs(Set<String> visit, Set<String> from, String goal) {
        if ( from.contains(goal) ) return 0;
        Set<String> from2 = new HashSet<>();
        for (String cur : from) {
            Set<String> t = create_state(cur);
            from2.addAll(t);
        }

        from2.removeAll(visit);
        if ( from2.isEmpty() ) return -1;

        visit.addAll(from2);
        int r = bfs( visit, from2, goal );
        if ( r < 0 ) return r;
        return 1+r;
    }

    private static Set<String> create_state(String cur) {
        Set<String> set = new HashSet<>(); 
        char[] cc = cur.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            try_move( cc, i, -1, set ); //左跳
            try_move( cc, i, -2, set );
            try_move( cc, i, -3, set );
            try_move( cc, i, 1, set );  //右跳
            try_move( cc, i, 2, set );
            try_move( cc, i, 3, set );
        }

        return set;
    }

    private static void try_move(char[] cc, int i, int d, Set<String> set) {
        if ( cc[i] == '*' ) return;
        int j = i + d;
        if ( j < 0 || j > cc.length ) return;
        if ( cc[j] != '*' ) return;

        cc[j] = cc[i]; cc[i] = '*'; //试探
        set.add(new String(cc));
        cc[i] = cc[j]; cc[j] = '*'; //跳回
    }
}
