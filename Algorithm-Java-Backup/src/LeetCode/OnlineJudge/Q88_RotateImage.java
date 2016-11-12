/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q88_RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 6}};
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
        System.out.println();
        new Q88_RotateImage().rotateMy(matrix);
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }

    public void rotateMy(int[][] matrix) {
        int edge = matrix.length;
        for (int layer = 0; layer < edge / 2; layer++) {
            for (int i = layer; i < edge - layer - 1; i++) {
                int temp = matrix[layer][layer + i];
                matrix[layer][layer + i] = matrix[edge - 1 - layer - i][layer];
                matrix[edge - 1 - layer - i][layer] = matrix[edge - 1 - layer][edge - 1 - layer - i];
                matrix[edge - 1 - layer][edge - 1 - layer - i] = matrix[layer + i][edge - 1 - layer];
                matrix[layer + i][edge - 1 - layer] = temp;
            }
        }
    }
}
