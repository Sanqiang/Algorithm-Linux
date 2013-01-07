/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.HashMap;
import sun.security.krb5.internal.KDCOptions;

public class Q9_11_BinaryRepresentation {

    HashMap<String, Integer> cache = new HashMap<>();

    public int f(String text, int s, int e, boolean result) {
        String key = String.valueOf(s) + (result ? "y" : "n") + String.valueOf(e);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (s == e) {
            if ((text.charAt(s) == '1' && result) || (text.charAt(s) == '0' && !result)) {
                return 1;
            } else {
                return 0;
            }
        }
        int ways = 0;
        if (result) {
            for (int m = s + 1; m <= e; m += 2) {
                switch (text.charAt(m)) {
                    case '&':
                        ways += f(text, s, m - 1, true) * f(text, m + 1, e, true);
                        break;
                    case '|':
                        ways += f(text, s, m - 1, true) * f(text, m + 1, e, false)
                                + f(text, s, m - 1, false) * f(text, m + 1, e, true)
                                + f(text, s, m - 1, true) * f(text, m + 1, e, true);
                        break;
                    case '^':
                        ways += f(text, s, m - 1, true) * f(text, m + 1, e, false)
                                + f(text, s, m - 1, false) * f(text, m + 1, e, true);
                        break;
                }
            }
        } else {
            for (int m = s + 1; m <= e; m += 2) {
                switch (text.charAt(m)) {
                    case '&':
                        ways += f(text, s, m - 1, false) * f(text, m + 1, e, false)
                                + f(text, s, m - 1, false) * f(text, m + 1, e, true)
                                + f(text, s, m - 1, true) * f(text, m + 1, e, true);
                        break;
                    case '|':
                        ways += f(text, s, m - 1, false) * f(text, m + 1, e, false);
                        break;
                    case '^':
                        ways += f(text, s, m - 1, true) * f(text, m + 1, e, true)
                                + f(text, s, m - 1, false) * f(text, m + 1, e, false);
                        break;
                }
            }
        }
        cache.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
    }
}
