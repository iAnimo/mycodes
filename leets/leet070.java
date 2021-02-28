package leets;

import java.util.Arrays;
import java.util.Vector;

public class leet070 {
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */
    Vector<Character[][]> result = new Vector<>();

    Vector<Character[][]> solveNQueens(int n) {
        result.clear();

        Character[][] chessboard = new Character[n][n];
        Arrays.fill(chessboard, '.');       // 批量赋值
        
        backtracking(n, 0, chessboard);
        return result;
    }

    void backtracking(int n, int row, Character[][] chessboard) {
        if (row == n) {
            result.add(chessboard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, chessboard, n)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row+1, chessboard);
                chessboard[row][col] = '.'; // 回溯，撤销皇后
            }
        }
    }

    private boolean isValid(int row, int col, Character[][] chessboard, int n) {
        // 列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 偏角
        for (int i = row-1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row-1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
