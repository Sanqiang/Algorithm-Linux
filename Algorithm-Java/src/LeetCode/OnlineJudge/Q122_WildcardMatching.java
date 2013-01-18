/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q122_WildcardMatching {

    public boolean isMatch(String s, String p) {
        int s_length = s.length(), p_length = p.length();
        if (s_length == 0) {
            return p_length == 0 || allStar(p);
        } else if (p_length == 0) {
            return s_length == 0;
        } else if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        } else {
            return false;
        }
    }

    private boolean allStar(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "zhaosanqiang";
        String p = "zhao?an*g";
        boolean match = new Q122_WildcardMatching().isMatch(s, p);
        System.out.println(match);
        boolean match2 = new Q122_WildcardMatching().isMatchMy(s, p);
        System.out.println(match2);
    }

    public boolean isMatchMy(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        if (s.equals(p)) {
            return true;
        } else if (s_len == 0 && p_len != 0) {
            if (allStarMy(p)) {
                return true;
            } else {
                return false;
            }
        } else if (s_len != 0 && p_len == 0) {
            return false;
        } else if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s.substring(1), p) || isMatchMy(s, p.substring(1));
        } else if (s.charAt(0) == p.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    private boolean allStarMy(String p) {
        for (char ch : p.toCharArray()) {
            if (ch != '*') {
                return false;
            }
        }
        return true;
    }
}
