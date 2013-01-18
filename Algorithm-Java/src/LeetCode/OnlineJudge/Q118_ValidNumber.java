/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q118_ValidNumber {

    public static void main(String[] args) {
        Q118_ValidNumber q118 = new Q118_ValidNumber();
        String s = "12.3";
        System.out.println(q118.isNum(s));
    }

    boolean isNum(String s) {
        boolean e = false, dot = false;
        if (s.charAt(0) == 'e') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                if (e) {
                    return false;
                } else {
                    e = true;
                }
            } else if (s.charAt(i) == '.') {
                if (dot) {
                    return false;
                } else {
                    dot = true;
                }
            } else if (!isNum(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
