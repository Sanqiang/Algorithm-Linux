/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q100_SpiralMatrix {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> solution = new ArrayList<>();
        int m = matrix.length - 1, n = matrix[0].length - 1;
        for (int i = 0; i <= Math.min(m, n) / 2; i++) {
            for (int col = i; col <= n - i; col++) {
                solution.add(matrix[i][col]);
            }
            for (int row = i + 1; row <= m - i; row++) {
                solution.add(matrix[row][n - i]);
            }
            if (m - i * 2 > 0) {
                for (int col = n - i - 1; col >= i; col--) {
                    solution.add(matrix[m - i][col]);
                }
            }
            if (n - i * 2 > 0) {
                for (int row = m - i - 1; row > i; row--) {
                    solution.add(matrix[row][i]);
                }
            }
        }
        return solution;
    }

    public ArrayList<Integer> spiralOrderEx(int[][] matrix) {
        ArrayList<Integer> solution = new ArrayList<>();
        int height = matrix.length, width = matrix[0].length;
        int col = 0, row = 0;
        int h = height, w = width;
        boolean GoRight = true, GoDown = false, GoLeft = false, GoUp = false;
        solution.add(matrix[0][0]);
        while (col <= h && row <= w) {
            int pre_row = row;
            while (GoRight) {
                ++row;
                if (row >= w) {
                    if (row - 1 == pre_row) {
                        break;
                    }
                    row = w - 1;
                    GoRight = false;
                    GoDown = true;
                } else {
                    solution.add(matrix[col][row]);
                }
            }
            int pre_col = col;
            while (GoDown) {
                ++col;
                if (col >= h) {
                    if (col - 1 == pre_col) {
                        break;
                    }
                    col = h - 1;
                    GoDown = false;
                    GoLeft = true;
                } else {
                    solution.add(matrix[col][row]);
                }
            }
            while (GoLeft) {
                --row;
                if (row < width - w) {
                    row = width - w;
                    GoLeft = false;
                    GoUp = true;
                } else {
                    solution.add(matrix[col][row]);
                }
            }
            while (GoUp) {
                --col;
                if (col <= height - h) {
                    col = height - h + 1;
                    GoUp = false;
                    GoRight = true;
                } else {
                    solution.add(matrix[col][row]);
                }
            }
            w -= 1;
            h -= 1;
        }
        return solution;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        ArrayList<Integer> solution = new Q100_SpiralMatrix().spiralOrderEx(matrix);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
        System.out.println();
        ArrayList<Integer> solution2 = new Q100_SpiralMatrix().spiralOrder(matrix);
        for (Integer integer : solution2) {
            System.out.print(integer + " ");
        }
    }
}
