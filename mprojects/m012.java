package mprojects;

/**
 * board:
 *  a b a
 *  a c d
 * word:
 *  [a,b,c,d]
 */
public class m012 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ( dfs( board, word, 0, i, j ) ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int u, int i, int j) {
        if ( u == word.length()- 1 ) {
            return true;
        }
        if ( i<0 || i>board.length || j<0 || j>board[0].length || board[i][j] != word.charAt(u) ) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = dfs ( board, word, u+1, i-1, j ) ||
                      dfs ( board, word, u+1, i+1, j ) || 
                      dfs ( board, word, u+1, i, j-1 ) || 
                      dfs ( board, word, u+1, i, j+1 );
        board[i][j] = temp;
        return res;
    }
}
