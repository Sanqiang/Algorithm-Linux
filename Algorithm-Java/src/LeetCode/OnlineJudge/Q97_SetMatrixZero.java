/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q97_SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 0, 8},
            {9, 1, 2, 3}
        };
        new Q97_SetMatrixZero().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[] col = new boolean[matrix.length];
        boolean[] row = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (col[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
