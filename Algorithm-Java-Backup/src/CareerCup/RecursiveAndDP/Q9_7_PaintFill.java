/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

public class Q9_7_PaintFill {

    enum Color {

        Red, Green, Yellow
    }

    public void paint(Color[][] canvas, int col, int row, Color ncolor, Color ocolor) {
        int height = canvas.length, width = canvas[0].length;
        if (col < 0 || col >= height || row < 0 || row >= width || canvas[col][row] != ocolor) {
            return;
        }
        canvas[col][row] = ncolor;
        paint(canvas, col - 1, row, ncolor, ocolor);
        paint(canvas, col + 1, row, ncolor, ocolor);
        paint(canvas, col, row - 1, ncolor, ocolor);
        paint(canvas, col, row + 1, ncolor, ocolor);
    }

    public static void main(String[] args) {
    }
}
