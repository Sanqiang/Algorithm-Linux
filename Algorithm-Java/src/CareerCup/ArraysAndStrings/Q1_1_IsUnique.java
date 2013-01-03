/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_1_IsUnique {

    boolean isUnique(String text) {
        int i, length = text.length();
        if (length > 0xff) {
            return false;
        }
        boolean[] charset = new boolean[0xff];
        for (i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (charset[ch]) {
                return false;
            } else {
                charset[ch] = true;
            }
        }
        return true;
    }

    boolean isUnique2(String text) {
        int i, length = text.length();
        if (length > 0xff) {
            return false;
        }
        int intchecker = 0;
        for (i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (((1 << ch) & intchecker) > 0) {
                return false;
            } else {
                intchecker |= (1 << ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_1_IsUnique q1 = new Q1_1_IsUnique();
        System.out.println(q1.isUnique2("abcda"));
    }
}
