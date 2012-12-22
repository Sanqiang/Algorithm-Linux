/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

public class Q47_MaxRectangle {

    public int maximalRectangle(char[][] matrix) {
        int i = 0, j = 0, height = matrix.length, width = matrix[0].length, max = 0;
        int[][] dp = new int[height][width];
        for (i = 0; i < height; ++i) {
            for (j = 0; j < width; ++j) {
                if (matrix[i][j] == '1') {
                    if (j >= 1) {
                        dp[i][j] = dp[i][j - 1] + 1;

                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (i = 0; i < height; ++i) {
            for (j = 0; j < width; ++j) {
                int k = i;
                int min = dp[k][j];
                while (k >= 0 && dp[k][j] != 0) {
                    min = Math.min(dp[k][j], min);
                    int h = i - k + 1;
                    int area = min * h;
                    max = Math.max(max, area);
                    --k;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '1', '1', '0'},
            {'1', '1', '1', '0'},
            {'1', '0', '0', '0'},
            {'1', '0', '0', '0'}
        };
        int area = new Q47_MaxRectangle().maximalRectangle(matrix);
        System.out.println(area);
    }
}
