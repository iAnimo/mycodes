package mprojects2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p098 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> from = new HashSet<>();
        from.add("9 0 0 0");
        Set<String> hist = new HashSet<>();
        hist.addAll(from);

        // String goal = scan.nextLine().trim();
        String goal = "3 3 3 0";
        System.out.println(f(hist, from, goal ));

        scan.close();
    }

    private static int f(Set<String> hist, Set<String> from, String goal) {
        if ( from.contains(goal) ) return 0;

        Set<String> from2 = new HashSet<>();
        for (String it : from) {
            Set<String> t = move(it.toString());    //向后移动一层
            from2.addAll(t);
        }

        from2.removeAll(hist);
        if ( from2.isEmpty() ) return -1;

        hist.addAll(from2);
        int r = f(hist, from2, goal);   //向后递归
        if ( r < 0 ) return r;
        return 1+r;
    }

    private static Set<String> move(String cur) {
        int[] cap = { 9,7,4,2 } ;   //瓶子容量
        int[] data = new int[4];
        String[] ss = cur.split(" ");
        for (int i = 0; i < 4; i++) {
            data[i] = Integer.parseInt(ss[i]);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss.length; j++) {
                if ( j == i ) continue;
                if ( data[i] == 0 ) continue;
                if ( data[j] == cap[j] ) continue;

                int sum = data[i] + data[j];
                // vi --> vj
                int vi = (sum <= cap[j]) ? 0:sum-cap[j];
                int vj = (sum <= cap[j]) ? sum:sum-cap[j];

                String s = "";
                for (int k = 0; k < ss.length; k++) {
                    if ( k == i ) {
                        s += vi + " ";
                    } else if ( k == j ) {
                        s += vj + " ";
                    } else {
                        s += data[k] + " ";
                    }
                    
                }
                set.add(s.trim());
            }
        }
        return set;
    }
}
