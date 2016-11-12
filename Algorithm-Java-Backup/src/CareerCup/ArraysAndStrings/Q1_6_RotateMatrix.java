/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_6_RotateMatrix {

    public void rotate(int[][] matrix) {
        int edge = matrix.length, i, level;
        for (level = 0; level < edge / 2; level++) {
            for (i = 0; i < edge - 2 * level - 1; i++) {
                int temp = matrix[level][i];
                matrix[level][level + i] = matrix[ edge - level - 1 - i][level];
                matrix[edge - level - 1 - i][level] = matrix[edge - 1 - level - i][level];
                matrix[edge - 1 - level - i][level] = matrix[edge - level - 1][edge - level - 1 - i];
                matrix[edge - level - 1][edge - level - 1 - i] = matrix[level + i][edge - level - 1];
                matrix[level + i][edge - level - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        new Q1_6_RotateMatrix().rotate(matrix);
        int edge = matrix.length;
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
