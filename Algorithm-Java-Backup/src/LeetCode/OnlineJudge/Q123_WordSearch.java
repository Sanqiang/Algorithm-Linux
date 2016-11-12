/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q123_WordSearch {

    public boolean exist(char[][] board, String word) {
        int height = board.length, width = board[0].length;
        boolean record[][] = new boolean[height][width];
        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
                if (board[col][row] == word.charAt(0)) {
                    if (existHelper(board, record, col, row, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, boolean[][] record, int col, int row, String word, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        record[col][row] = true;
        char ch = word.charAt(index + 1);
        int height = board.length, width = board[0].length;
        boolean up = false;
        if (col - 1 >= 0 && ch == board[col - 1][row] && !record[col - 1][row]) {
            up = existHelper(board, record, col - 1, row, word, index + 1);
            record[col - 1][row] = false;
        }
        if (up) {
            return true;
        }
        boolean down = false;
        if (col + 1 < height && ch == board[col + 1][row] && !record[col + 1][row]) {
            down = existHelper(board, record, col + 1, row, word, index + 1);
            record[col + 1][row] = false;
        }
        if (down) {
            return true;
        }
        boolean left = false;
        if (row - 1 >= 0 && ch == board[col][row - 1] && !record[col][row - 1]) {
            up = existHelper(board, record, col, row - 1, word, index + 1);
            record[col][row - 1] = false;
        }
        if (left) {
            return true;
        }
        boolean right = false;
        if (row + 1 < width && ch == board[col][row + 1] && !record[col][row + 1]) {
            up = existHelper(board, record, col, row + 1, word, index + 1);
            record[col][row + 1] = false;
        }
        if (right) {
            return true;
        }
        return left | right | up | down;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCE";
        boolean result = new Q123_WordSearch().existMy(board, word);
        System.out.println(result);
    }

    public boolean existMy(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && go(board, word, 1, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean go(char[][] board, String word, int i, int col, int row) {
        if (word.length() == i) {
            return true;
        } else if (col < 0 || col >= board.length || row < 0 || row >= board[0].length) {
            return false;
        }
        if (col + 1 < board.length && board[col + 1][row] == word.charAt(i) && go(board, word, i + 1, col + 1, row)) {
            return true;
        }
        if (col - 1 >= 0 && board[col - 1][row] == word.charAt(i) && go(board, word, i + 1, col - 1, row)) {
            return true;
        }
        if (row + 1 < board[0].length && board[col][row + 1] == word.charAt(i) && go(board, word, i + 1, col, row + 1)) {
            return true;
        }
        if (row - 1 >= 0 && board[col][row - 1] == word.charAt(i) && go(board, word, i + 1, col, row - 1)) {
            return true;
        }
        return false;
    }
}
