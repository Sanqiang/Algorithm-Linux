/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ArraysAndStrings;

public class Q1_4_UrlEncode {

    void encode(char[] text, int length) {
        int i, newlength = length, j;
        for (i = 0; i < length; i++) {
            char ch = text[i];
            if (ch == ' ') {
                newlength += 2;
            }
        }
        j = newlength - 1;
        for (i = length - 1; i >= 0; --i) {
            if (text[i] != ' ') {
                text[j--] = text[i];
            } else {
                text[j--] = '0';
                text[j--] = '2';
                text[j--] = '%';
            }
        }
    }

    public static void main(String[] args) {
        char[] text = "abc def         ".toCharArray();
        Q1_4_UrlEncode q1 = new Q1_4_UrlEncode();
        q1.encode(text, 7);
        for (char c : text) {
            System.out.print(c);
        }

    }
}
