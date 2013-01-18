/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q91_ScrambleString {

    public boolean isScramble(String s1, String s2) {
        int s2_length = s2.length(), s1_length = s1.length();
        if (s1.equals(s2)) {
            return true;
        } else if (s1_length != s2_length) {
            return false;
        } else if (s1_length == 1 && (!s1.equals(s2))) {
            return false;
        } else {
            for (int i = 1; i <= s1_length / 2; i++) {
                String a1 = s1.substring(0, i);
                String b1 = s1.substring(i);
                String a2 = s2.substring(0, i);
                String b2 = s2.substring(i);
                String c1 = s1.substring(0, s1_length - i);
                String d1 = s1.substring(s1_length - i);
                String c2 = s2.substring(0, s2_length - i);
                String d2 = s2.substring(s2_length - i);

                if (isScramble(a1, a2) && isScramble(b1, b2)) {
                    return true;
                }
                if (isScramble(a1, d2) && isScramble(b1, c2)) {
                    return true;
                }
                if (isScramble(d1, a2) && isScramble(c1, b2)) {
                    return true;
                }
                if (isScramble(d1, d2) && isScramble(c1, c2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "rgeat";
        String s2 = "raegr";
        boolean result = new Q91_ScrambleString().isScramble(s1, s2);
        System.out.println(result);
    }

    public boolean isScrambleMy(String s1, String s2) {
        int s1_len = s1.length(), s2_len = s2.length();
        if (s1.equals(s2)) {
            return true;
        } else if (s1_len != s2_len) {
            return false;
        } else if (s1_len == 1 && !s1.equals(s2)) {
            return false;
        } else {
            for (int i = 1; i <= s1_len / 2; i++) {
                String a1 = s1.substring(0, i), b1 = s1.substring(i), c1 = s1.substring(0, s1_len - i), d1 = s1.substring(s1_len - i);
                String a2 = s2.substring(0, i), b2 = s2.substring(i), c2 = s2.substring(0, s1_len - i), d2 = s2.substring(s1_len - i);
                if (isScrambleMy(a1, a2) && isScrambleMy(b1, b2)) {
                    return true;
                }
                if (isScrambleMy(c1, c2) && isScrambleMy(d1, d2)) {
                    return true;
                }
                if (isScrambleMy(a1, d2) && isScrambleMy(b1, c2)) {
                    return true;
                }
                if (isScrambleMy(c1, b2) && isScrambleMy(d1, a2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
