/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;

public class Q56_MinPathSum {

    public int minPathSumDP(int[][] grid) {
        int i, j, height = grid.length, width = grid[0].length;
        int dp[][] = new int[height][width];
        dp[0][0] = grid[0][0];
        for (i = 0; i < height; ++i) {
            for (j = 0; j < width; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[height - 1][width - 1];
    }

    public int minPathSum(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        return minPathSumHelper(grid, height - 1, width - 1);
    }

    private int minPathSumHelper(int grid[][], int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        } else if (i == 0) {
            return grid[i][j] + minPathSumHelper(grid, i, j - 1);
        } else if (j == 0) {
            return grid[i][j] + minPathSumHelper(grid, i - 1, j);
        } else {
            return grid[i][j] + Math.min(minPathSumHelper(grid, i - 1, j), minPathSumHelper(grid, i, j - 1));
        }
    }

    public static void main(String[] args) {
        int grid[][] = TestUtil.generateMatrix(10, 10, 5);
        long l1 = System.currentTimeMillis();
        int sum1 = new Q56_MinPathSum().minPathSum(grid);
        long l2 = System.currentTimeMillis();
        int sum2 = new Q56_MinPathSum().minPathSumDP(grid);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(sum1 + " Cost " + span1);
        System.out.println(sum2 + " Cost " + span2);
    }
}
