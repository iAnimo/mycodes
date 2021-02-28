package leets;

public class leet071 {
    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     */
    boolean backtracking(Character[][] board) {
        // 不用终止条件

        // 二维递归
        for (int i = 0; i < board.length; i++) { // 遍历行
            for (int j = 0; j < board[0].length; j++) { // 遍历列
                if (board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) { // (i, j) 这个位置放k是否合适
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k; // 放置k
                        if (backtracking(board)) {
                            return true; // 如果找到合适一组立刻返回
                        }
                        board[i][j] = '.'; // 回溯，撤销k
                    }
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true; // 遍历完没有返回false，说明找到了合适棋盘位置了
    }

    private boolean isValid(int row, int col, char val, Character[][] board) {
        for (int i = 0; i < 9; i++) {

            // 行
            if (board[row][i] == val) {
                return false;
            }

            // 列
            if (board[i][col] == val) {
                return false;
            }
        }

        // 方格

        //  row/3 表示 第row/3个格
        // (row / 3) * 3 表示 第row/3个格第一个格子的编号
        int r = (row / 3) * 3; 
        int c = (col / 3) * 3;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (board[r][c] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
