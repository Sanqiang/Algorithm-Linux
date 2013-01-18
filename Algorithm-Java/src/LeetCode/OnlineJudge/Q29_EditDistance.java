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
        String word2 = "aeec";
        int dis = new Q29_EditDistance().minDistanceMy(word1, word2);
        System.out.println(dis);
    }

    //my way
    int minDistanceMy(String word1, String word2) {
        int w1_len = word1.length(), w2_len = word2.length(), i, j;
        int[][] tab = new int[w1_len][w2_len];
        if (word1.charAt(0) == word2.charAt(0)) {
            tab[0][0] = 0;
        } else {
            tab[0][0] = 1;
        }
        for (i = 1; i < w1_len; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                tab[i][0] = tab[i - 1][0];
            } else {
                tab[i][0] = 1 + tab[i - 1][0];
            }
        }
        for (i = 1; i < w2_len; i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                tab[0][i] = tab[0][i - 1];
            } else {
                tab[0][i] = 1 + tab[0][i - 1];
            }
        }
        for (i = 1; i < w1_len; i++) {
            for (j = 1; j < w2_len; j++) {
                int min = Math.min(Math.min(tab[i - 1][j], tab[i][j - 1]), tab[i - 1][j - 1]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    tab[i][j] = min;
                } else {
                    tab[i][j] = 1 + min;
                }
            }
        }
        return tab[w1_len - 1][w2_len - 1];
    }
}
