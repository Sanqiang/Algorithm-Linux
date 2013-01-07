/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

public class Q9_9_PlaceQueen {

    final int GRID_SIZE = 8;

    public void place() {
        place(0, new int[GRID_SIZE]);
    }

    public void place(int row, int[] chess) {
        if (row == GRID_SIZE) {
            print(chess);
            return;
        }

        for (int i = 0; i < GRID_SIZE; i++) {
            chess[row] = i;
            if (checkValid(row, chess)) {
                place(row + 1, chess);
            }
        }
    }

    private boolean checkValid(int row, int[] chess) {
        for (int i = 0; i < row; i++) {
            int w = Math.abs(chess[i] - chess[row]);
            int h = Math.abs(i - row);
            if (w == 0 || w == h) {
                return false;
            }
        }
        return true;
    }

    private void print(int[] chess) {
        for (int i = 0; i < GRID_SIZE; i++) {
            int col = chess[i];
            int j = 0;
            for (; j < col; j++) {
                System.out.print("_");
            }
            System.out.print("*");
            for (j = col + 1; j < GRID_SIZE; j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q9_9_PlaceQueen q99 = new Q9_9_PlaceQueen();
        q99.place();
    }
}
