/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_Othello;

public class Board {

    private Piece[][] board;
    private int height;
    private int width;
    int black_score = 0;
    int white_score = 0;

    public Board(int _column, int _row) {
        this.board = new Piece[_column][_row];
        height = _column;
        width = _row;
        initiailize();
    }

    private void initiailize() {
        board[4][4] = new Piece(Color.Black);
        board[5][5] = new Piece(Color.Black);
        board[4][5] = new Piece(Color.White);
        board[5][4] = new Piece(Color.White);
        black_score = 2;
        white_score = 2;
    }

    public boolean placePiece(int col, int row, Color me) {
        if (board[col][row] != null) {
            return false;
        }
        int direction[] = new int[4];
        if (col >= 1 && board[col - 1][row] != null && board[col - 1][row].getColor() != me) {
            direction[0] = placePieceHelper(col - 1, row, me, Direciton.Up);
            if (direction[0] > 0) {
                //board[col - 1][row].flip();
            }

        }
        if (col < height - 2 && board[col + 1][row] != null && board[col + 1][row].getColor() != me) {
            direction[1] = placePieceHelper(col + 1, row, me, Direciton.Down);
            if (direction[1] > 0) {
                //board[col + 1][row].flip();
            }
        }
        if (row >= 1 && board[col][row - 1] != null && board[col][row - 1].getColor() != me) {
            direction[2] = placePieceHelper(col, row - 1, me, Direciton.Left);
            if (direction[2] > 0) {
                //board[col][row - 1].flip();
            }
        }
        if (row < width - 2 && board[col][row + 1] != null && board[col][row + 1].getColor() != me) {
            direction[3] = placePieceHelper(col, row + 1, me, Direciton.Right);
            if (direction[3] > 0) {
                //board[col][row + 1].flip();
            }
        }
        int count = 0;
        for (int i : direction) {
            count += i;
        }
        if (count <= 0) {
            return false;
        } else {
            board[col][row] = new Piece(me);
            updateScore(me, count);
            return true;
        }
    }

    private int placePieceHelper(int col, int row, Color me, Direciton d) {
        int h = 0, v = 0;
        switch (d) {
            case Up:
                v = -1;
                break;
            case Down:
                v = 1;
                break;
            case Left:
                h = -1;
                break;
            case Right:
                h = 1;
                break;
        }
        if (board[col][row] == null || board[col][row].getColor() == me) {
            return 0;
        }
        if (col < 0 || row < 0 || col > height - 1 || row > width - 1) {
            return -1;
        }
        int count = placePieceHelper(col + v, row + h, me, d);
        if (count >= 0) {
            board[col][row].flip();
            return 1 + count;
        } else {
            return -1;
        }
    }

    private void updateScore(Color color, int num) {
        if (color == Color.Black) {
            black_score += num + 1;
            white_score -= num;
        } else {
            black_score -= num;
            white_score += num + 1;
        }
    }

    public void print() {
        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
                if (board[col][row] == null) {
                    System.out.print("_");
                } else if (board[col][row].getColor() == Color.Black) {
                    System.out.print("B");
                } else if (board[col][row].getColor() == Color.White) {
                    System.out.print("W");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    }
}
