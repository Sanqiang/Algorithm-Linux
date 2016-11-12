/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.Moderate;

public class Q17_2_TicTacToe {

    enum Piece {

        X, O, Empty
    }

    public Piece hasWon(Piece[][] board) {
        int n = board.length;
        int col, row;
        //Check row
        for (col = 0; col < n; col++) {
            if (board[col][0] == Piece.Empty) {
                break;
            }
            for (row = 1; row < n; row++) {
                if (board[col][row] == Piece.Empty || board[col][row] != board[col][row - 1]) {
                    break;
                }
                if (row == n - 1) {
                    return board[col][row];
                }
            }
        }
        //check col
        for (row = 0; row < n; row++) {
            if (board[col][row] == Piece.Empty) {
                break;
            }
            for (col = 1; col < n; col++) {
                if (board[col][row] == Piece.Empty || board[col][row] != board[col - 1][row]) {
                    break;
                }
            }
            if (col == n - 1) {
                return board[col][row];
            }
        }
        //diagonal
        if (board[0][0] != Piece.Empty) {
            for (col = 1; col < n; col++) {
                if (board[col][col] == Piece.Empty || board[col][col] != board[col - 1][col - 1]) {
                    break;
                }
                if (col == n - 1) {
                    return board[col][col];
                }
            }
        }
        //reverse diagonal
        if (board[0][n - 1] != Piece.Empty) {
            for (col = 1; col < n; col++) {
                if (board[col][n - 1 - col] == Piece.Empty || board[col][n - 1 - col] != board[col - 1][n - col]) {
                    break;
                }
                if (col == n - 1) {
                    return board[col][n - 1 - col];
                }
            }
        }
        return Piece.Empty;
    }

    public static void main(String[] args) {
    }
}
