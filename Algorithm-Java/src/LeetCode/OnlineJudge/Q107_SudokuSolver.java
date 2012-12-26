/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q107_SudokuSolver {

    public void solveSudoku(char[][] board) {
        int height = board.length, width = board[0].length, col, row;
        for (col = 0; col < height; ++col) {
            for (row = 0; row < width; row++) {
                if (board[col][row] == '.') {
                    for (char ch = '0'; ch <= '9'; ch++) {
                        board[col][row] = ch;
                        if (isValid(board, col, row)) {
                            solveSudoku(board);
                        } else {
                            board[col][row] = '.';
                        }
                    }
                }
            }
        }
    }

    private boolean isValid(char[][] board, int col, int row) {
        int i, j;
        boolean tab[] = new boolean[10];
        for (i = 0; i < 9; i++) {
            if (board[col][i] != '.') {
                if (tab[board[col][i] - '0']) {
                    return false;
                } else {
                    tab[board[col][i] - '0'] = true;
                }
            }
        }
        tab = new boolean[10];
        for (i = 0; i < 9; i++) {
            if (board[i][row] != '.') {
                if (tab[board[i][row] - '0']) {
                    return false;
                } else {
                    tab[board[i][row] - '0'] = true;
                }
            }
        }
        tab = new boolean[10];
        for (i = col / 3; i <= col / 3 + 3; i++) {
            for (j = row / 3; j <= row / 3 + 3; j++) {
                if (board[i][j] != '.') {
                    if (tab[board[i][j] - '0']) {
                        return false;
                    } else {
                        tab[board[i][j] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Q107_SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
