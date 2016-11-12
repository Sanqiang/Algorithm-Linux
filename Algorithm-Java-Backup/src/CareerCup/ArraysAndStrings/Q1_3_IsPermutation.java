/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_3_IsPermutation {

    boolean isPermutation(String text, String pattern) {
        int i, length = text.length();
        if (length != pattern.length()) {
            return false;
        }
        short[] charset = new short[0xff];
        for (i = 0; i < length; i++) {
            ++charset[text.charAt(i)];
        }
        for (i = 0; i < length; i++) {
            --charset[text.charAt(i)];
            if (charset[text.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
