/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_Othello;

public class Game {

    private int column = 10;
    private int row = 10;
    private Board board;
    private static Game instance = null;
    private Player players[];

    private Game() {
        board = new Board(column, row);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        Game g = Game.getInstance();
        Board b = g.getBoard();
        b.print();
        boolean result = b.placePiece(4, 3, Color.White);
        b.placePiece(5, 6, Color.White);
        b.print();
    }
}
