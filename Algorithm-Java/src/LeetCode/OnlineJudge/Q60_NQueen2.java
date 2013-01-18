/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q60_NQueen2 {

    public static void main(String[] args) {
        int ways = new Q60_NQueen2().solveNQueensMy(100000);
        System.out.println(ways);
    }

    public int solveNQueensMy(int n) {
        int[] board = new int[n];
        IntWrapper iw = new IntWrapper();
        solveNqueensHelper(board, iw, 0);
        return iw.i;
    }

    class IntWrapper {

        int i = 0;
    }

    private void solveNqueensHelper(int[] board, IntWrapper iw, int row) {
        if (row == board.length) {
            ++iw.i;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row] = i;
            if (checkBoard(board, row)) {
                solveNqueensHelper(board, iw, row + 1);
            }
        }
    }

    private boolean checkBoard(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            int dif_col = Math.abs(i - row);
            int dif_row = Math.abs(board[row] - board[i]);
            if (dif_col == dif_row || dif_row == 0) {
                return false;
            }
        }
        return true;
    }
}
