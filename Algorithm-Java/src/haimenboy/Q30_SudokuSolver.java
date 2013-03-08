/**
 * Sanqiang Zhao Www.131X.Com Jan 27, 2013
 */
package haimenboy;

public class Q30_SudokuSolver {

    public boolean solveSudoku(int[][] board) {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                if (board[col][row] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        board[col][row] = num;
                        if (solve(board, col, row)) {
                            if (solveSudoku(board)) {
                                return true;
                            }
                        }
                        board[col][row] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(int[][] board, int col, int row) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < board.length; i++) {
            int val = board[i][row] - 1;
            if (val == -1) {
                continue;
            }
            if (check[val]) {
                return false;
            } else {
                check[val] = true;
            }
        }
        check = new boolean[9];
        for (int i = 0; i < board[0].length; i++) {
            int val = board[col][i] - 1;
            if (val == -1) {
                continue;
            }
            if (check[val]) {
                return false;
            } else {
                check[val] = true;
            }
        }
        check = new boolean[9];
        for (int y = col / 3 * 3; y < col / 3 * 3 + 3; y++) {
            for (int x = row / 3 * 3; x < row / 3 * 3 + 3; x++) {
                int val = board[y][x] - 1;
                if (val == -1) {
                    continue;
                }
                if (check[val]) {
                    return false;
                } else {
                    check[val] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        new Q30_SudokuSolver().solveSudoku(board);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println();
        }
    }
}
