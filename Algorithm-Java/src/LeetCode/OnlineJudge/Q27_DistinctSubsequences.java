/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package LeetCode.OnlineJudge;

public class Q27_DistinctSubsequences {

    int numDistinct(String S, String T) {
        int s_i = 0, t_i = 0, s_length = S.length(), t_length = T.length(), i, j;
        int[][] cache = new int[s_length + 1][t_length + 1];
        cache[0][0] = 1;
        for (i = 1; i < s_length + 1; i++) {
            cache[i][0] = 0;
        }
        for (i = 1; i < t_length + 1; i++) {
            cache[0][i] = 0;
        }
        for (i = 1; i < s_length + 1; i++) {
            for (j = 1; j < t_length + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    cache[i][j] = 0;
                    for (int k = 0; k < i; k++) {
                        cache[i][j] += cache[k][j - 1];
                    }
                } else {
                    cache[i][j] = 0;
                }
            }
        }
        int sum = 0;
        for (i = 0; i < s_length + 1; ++i) {
            sum += cache[i][t_length];
        }
        return sum;
    }

    public static void main(String[] args) {
        String S = "rabb";
        String T = "rab";
        int num = new Q27_DistinctSubsequences().numDistinct(S, T);
        System.out.println(num);
    }
}
