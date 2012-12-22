/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package LeetCode.OnlineJudge;

public class Q29_EditDistance {

    int minDistance(String word1, String word2) {
        int w1_length = word1.length();
        int w2_length = word2.length();
        int[][] cache = new int[w1_length + 1][w2_length + 1];
        int i, j;
        for (i = 0; i < w1_length + 1; ++i) {
            cache[i][0] = i;
        }
        for (j = 0; j < w2_length; ++j) {
            cache[0][j] = j;
        }
        for (i = 1; i < w1_length + 1; ++i) {
            for (j = 1; j < w2_length + 1; ++j) {
                int min = Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]);
                cache[i][j] = min + word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
            }
        }

        return cache[w1_length][w2_length];
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "abc";
        int dis = new Q29_EditDistance().minDistance(word1, word2);
        System.out.println(dis);
    }
}
