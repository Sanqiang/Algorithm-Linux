/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.ArraysAndStrings;

public class KMP {

    public int search(String text, String pattern) {
        int count = 0, length = text.length(), p_length = pattern.length(), i = 0, pos = 0;
        int[] tab = next(pattern);
        while (i < length) {
            if (text.charAt(i) == pattern.charAt(pos)) {
                ++pos;
                if (pos == p_length) {
                    ++count;
                    pos = 0;
                }
            } else {
                if (pos > 0) {
                    pos = tab[pos - 1] - 1;
                }
            }
            ++i;
        }
        return count;
    }

    public int[] next(String pattern) {
        int pos = 0, i = 1, length = pattern.length();
        int[] tab = new int[length];
        //tab[0] = -1;
        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(pos)) {
                tab[i++] = ++pos;
            } else {
                if (pos > 0) {
                    --pos;
                } else {
                    tab[i++] = pos;
                }
            }
        }
        return tab;
    }

    public static void main(String[] args) {
        String pattern = "ababdab";
        String text = "ababdabssababdab";
        KMP kmp = new KMP();
        int count = kmp.search(text, pattern);
        System.out.println(count);
    }
}
