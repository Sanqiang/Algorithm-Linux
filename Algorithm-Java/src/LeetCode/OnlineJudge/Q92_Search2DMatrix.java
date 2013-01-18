/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q92_Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length, height = matrix.length;
        int col = 0, row = width - 1;
        while (col < height && row >= 0) {
            if (matrix[col][row] == target) {
                return true;
            } else if (matrix[col][row] > target) {
                --row;
            } else {
                ++col;
            }
        }
        return false;
    }
}
