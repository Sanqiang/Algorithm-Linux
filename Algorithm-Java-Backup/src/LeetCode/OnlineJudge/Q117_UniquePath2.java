/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q117_UniquePath2 {

    //the same as Q116
    public static void main(String[] args) {
    }

    public int uniquePathsMy(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (isFree(i, 0)) {
                matrix[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (isFree(0, i)) {
                matrix[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (isFree(i, j)) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        return matrix[m - 1][n - 1];
    }

    boolean isFree(int m, int n) {
        return true;
    }
}
