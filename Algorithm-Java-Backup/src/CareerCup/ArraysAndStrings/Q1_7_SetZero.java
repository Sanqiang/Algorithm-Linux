/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_7_SetZero {

    void setZero(int[][] matrix) {
        int col, row, height = matrix.length, width = matrix[0].length;
        boolean[] col_list = new boolean[height], row_list = new boolean[width];
        for (col = 0; col < height; col++) {
            for (row = 0; row < width; row++) {
                if (matrix[col][row] == 0) {
                    col_list[col] = true;
                    row_list[row] = true;
                }
            }
        }
        for (col = 0; col < height; col++) {
            for (row = 0; row < width; row++) {
                if (col_list[col] || row_list[row]) {
                    matrix[col][row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
