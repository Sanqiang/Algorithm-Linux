/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_5_CompressText {

    String compress(String text) {

        int i, length = text.length();
        if (getLength(text) >= length) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (i = 1; i < length; i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                ++count;
            } else {
                sb.append(text.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        sb.append(text.charAt(i - 1)).append(count);
        return sb.toString();
    }

    int getLength(String text) {
        int size = 0;
        int i, length = text.length();
        int count = 1;
        for (i = 1; i < length; i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                ++count;
            } else {
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static void main(String[] args) {
        Q1_5_CompressText q1 = new Q1_5_CompressText();
        String encrypt = q1.compress("aaaahhhuuuu");
        System.out.println(encrypt);
    }
}
