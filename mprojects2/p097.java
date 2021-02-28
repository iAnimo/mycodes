package mprojects2;
import java.util.HashSet;
import java.util.Set;

public class p097 {
    /**
     * s..11
     * .1.11
     * .1..e
     * s:start, e:end, 1:wall, .:road
     */
    static int f(char[][] data, Set<String> from, String goal) {    //广度优先遍历
        if ( from.contains(goal) ) return 0;

        Set<String> set = new HashSet<>();  //相邻
        for (String s : from) {
            String[] ss = s.split(","); //a,b
            int y = Integer.parseInt(ss[0]);
            int x = Integer.parseInt(ss[1]);

            if ( y>0 && data[y-1][x] == '.' ) { data[y-1][x] = '*';set.add((y-1)+","+x); }
            if ( y<data.length-1 && data[y+1][x] == '.' ) { data[y+1][x] = '*';set.add((y+1)+","+x); }
            if ( x>0 && data[y][x-1] == '.' ) { data[y][x-1] = '*';set.add(y+","+(x-1)); }
            if ( x<data[0].length-1 && data[y][x+1] == '.' ) { data[y][x+1] = '*';set.add(y+","+(x+1)); }
        }

        if ( set.isEmpty() ) return -1;
        int r = f(data, set, goal) ;
        if ( r < 0 ) return -1;
        return r+1;
    }

}
