package mprojects;

import java.util.HashSet;
import java.util.Set;

public class m038 {
    Set<String> res = new HashSet<>();
    public String[] permutation(String s) {
        if ( s == null ) {
            return new String[]{};
        }
        boolean[] visited = new boolean[s.length()];
        dfs(s, "", visited);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(String s, String ch, boolean[] visited) {
        if ( s.length() == ch.length() ) {
            res.add(ch);
            return ;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if ( visited[i] ) continue;
            visited[i] = true;
            dfs( s, ch+String.valueOf(temp), visited );
            visited[i] = false; //回溯
        }
    }
    
}
