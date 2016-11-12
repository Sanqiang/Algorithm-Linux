/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q59_NQueen {

    public static void main(String[] args) {
        ArrayList<String[]> solution = new Q59_NQueen().solveNQueensMy(4);
        for (String[] strings : solution) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }

    public ArrayList<String[]> solveNQueensMy(int n) {
        ArrayList<String[]> solutions = new ArrayList<>();
        int[] board = new int[n];
        solveNqueensHelper(board, solutions, 0);
        return solutions;
    }

    private void solveNqueensHelper(int[] board, ArrayList<String[]> solutions, int row) {
        if (row == board.length) {
            solutions.add(transform(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row] = i;
            if (checkBoard(board, row)) {
                solveNqueensHelper(board, solutions, row + 1);
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

    private String[] transform(int[] board) {
        String[] conv = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i]; j++) {
                sb.append(".");
            }
            sb.append("G");
            for (int j = board[i] + 1; j < board.length; j++) {
                sb.append(".");
            }
            conv[i] = sb.toString();
        }
        return conv;
    }
}
