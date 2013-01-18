/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

public class Q37_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1_length = s1.length(), s2_length = s2.length(), s3_length = s3.length(), i = 1, j = 1;
        boolean[][] cache = new boolean[s1_length + 1][s2_length + 1];
        cache[0][0] = true;
        for (i = 1; i <= s1_length; ++i) {
            cache[i][0] = cache[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (j = 1; j <= s2_length; ++j) {
            cache[0][j] = cache[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (i = 1; i <= s1_length; ++i) {
            for (j = 1; j <= s2_length; ++j) {
                cache[i][j] = (cache[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (cache[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return cache[s1_length][s2_length];
    }

    public static void main(String[] args) {
        String s1 = "ac";
        String s2 = "ca";
        String s3 = "caca";
        boolean result = new Q37_InterleavingString().isInterleaveMy(s1, s2, s3);
        System.out.println(result);
    }

    //my way
    public boolean isInterleaveMy(String s1, String s2, String s3) {
        int s1_len = s1.length(), s2_len = s2.length(), s3_len = s3.length();
        if (s1_len + s2_len != s3_len) {
            return false;
        }
        boolean[][] tab = new boolean[1 + s1_len][1 + s2_len];
        tab[0][0] = true;
        for (int i = 1; i <= s1_len; i++) {
            tab[i][0] = tab[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= s2_len; i++) {
            tab[0][i] = tab[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= s1_len; i++) {
            for (int j = 1; j <= s2_len; j++) {
                tab[i][j] = tab[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || tab[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return tab[s1_len][s2_len];
    }
}
