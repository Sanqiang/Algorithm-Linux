/**
 * Sanqiang Zhao Www.131X.Com Jan 25, 2013
 */
package haimenboy;

public class Q19_MatrixSpiral {

    void print(int[][] matrix, int col, int row, int width, int height) {
        if (col == matrix.length || row == matrix[0].length) {
            return;
        }
        for (int i = 0; i < width; i++) {
            System.out.print(matrix[col][row + i] + " ");
        }
        for (int i = 1; i < height; i++) {
            System.out.print(matrix[col + i][row + width - 1] + " ");
        }
        if (height > 1) {
            for (int i = 1; i < width; i++) {
                System.out.print(matrix[col + height - 1][row + width - 1 - i] + " ");
            }
        }
        if (width > 1) {
            for (int i = 1; i < height - 1; i++) {
                System.out.print(matrix[col + height - 1 - i][row] + " ");
            }
        }

        print(matrix, col + 1, row + 1, width - 2, height - 2);
    }

    void print(int[][] matrix) {
        int col = 0, row = -1, i = 0, len = 0;
        while (true) {
            if (i % 2 == 0) {
                len = matrix[0].length - i / 2;
            } else {
                len = matrix.length - i / 2 - 1;
            }
            if (len == 0) {
                return;
            }
            int xd = 0, yd = 0;
            switch (i % 4) {
                case 0:
                    xd = 1;
                    break;
                case 1:
                    yd = 1;
                    break;
                case 2:
                    xd = -1;
                    break;
                case 3:
                    yd = -1;
                    break;
            }
            for (int pos = 0; pos < len; pos++) {
                System.out.print(matrix[col + (1 + pos) * yd][row + (1 + pos) * xd] + " ");
            }
            col += len * yd;
            row += len * xd;
            ++i;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        //new Q19_MatrixSpiral().print(matrix, 0, 0, matrix[0].length, matrix.length);
        new Q19_MatrixSpiral().print(matrix);
    }
}
