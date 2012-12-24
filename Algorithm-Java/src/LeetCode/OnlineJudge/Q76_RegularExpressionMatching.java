/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

public class Q76_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int s_length = s.length(), p_length = p.length();
        if (s_length == 0) {
            return checkempty(p);
        }
        if (p_length == 0) {
            return false;
        }
        char c1 = s.charAt(0);
        char p1 = p.charAt(0), p2 = '\0';
        if (p_length > 1) {
            p2 = p.charAt(1);
        }
        if (p2 == '*') {
            if (p1 == '.' || c1 == p1) {
                return isMatch(s.substring(1), p)||isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (p1 == '.' || c1 == p1) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    private boolean checkempty(String p) {
        if ((p.length() % 2) != 0) {
            return false;
        }
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatchSample(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error
        // Start typing your Java solution below
        // DO NOT write main() function

        int i = 0, j = 0;
        //you don't have to construct a state machine for this problem

        if (s.length() == 0) {
            return checkEmpty(p);
        }

        if (p.length() == 0) {
            return false;
        }

        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do

        if (p.length() > 1) {
            d2 = p.charAt(1);
        }

        if (d2 == '*') {
            if (d1 == '.' || c1 == d1) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern

                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (d1 == '.' || c1 == d1) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    public boolean checkEmpty(String p) {
        if (p.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "*";
        boolean result = new Q76_RegularExpressionMatching().isMatch(s, p);
        System.out.println(result);
    }
}
