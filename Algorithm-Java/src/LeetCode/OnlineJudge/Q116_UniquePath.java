/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import java.util.HashMap;

public class Q116_UniquePath {

    public int uniquePathsDP(int m, int n) {
        int[][] DP = new int[m][n];
        int i, j;
        DP[0][0] = 1;
        for (i = 1; i < m; i++) {
            DP[i][0] = 1;
        }
        for (i = 1; i < n; i++) {
            DP[0][i] = 1;
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
            }
        }
        return DP[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        cache = new HashMap<>();
        return uniquePathsHelper(m, n);
    }
    HashMap<String, Integer> cache;

    private int uniquePathsHelper(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        String key = String.valueOf(m) + "-" + String.valueOf(n);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ways = 0;
        if (m > 0) {
            ways += uniquePathsHelper(m - 1, n);
        }
        if (n > 0) {
            ways += uniquePathsHelper(m, n - 1);
        }
        cache.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        int m = 1, n = 1;
        int ways = new Q116_UniquePath().uniquePaths(m, n);
        System.out.println(ways);
        int ways2 = new Q116_UniquePath().uniquePathsDP(m, n);
        System.out.println(ways2);

        int tm = 100, tn = 100;
        long l1 = System.currentTimeMillis();
        int tways = new Q116_UniquePath().uniquePaths(tm, tn);
        long l2 = System.currentTimeMillis();
        int tways2 = new Q116_UniquePath().uniquePathsDP(tm, tn);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(tways + " Cost " + span1);
        System.out.println(tways2 + " Cost " + span2);
    }
}
