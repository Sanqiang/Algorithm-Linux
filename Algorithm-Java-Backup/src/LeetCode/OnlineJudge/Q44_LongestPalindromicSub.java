/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

public class Q44_LongestPalindromicSub {

    public String longestPalindromeEx(String s) {
        int length = s.length(), i = 0;
        int palindrome_length = 0;
        String palindrome = "";
        for (; i < length; ++i) {
            if (i + 1 < length && s.charAt(i) == s.charAt(1 + i)) {
                int cur_length = longestPalindromeExHelper(i, 1 + i, s, length);
                if (cur_length > palindrome_length) {
                    palindrome = s.substring(i - cur_length / 2 + 1, i + 1 + cur_length / 2 - 1 + 1);
                    palindrome_length = cur_length;
                }
            }
            if (i + 2 < length && s.charAt(i) == s.charAt(2 + i)) {
                int cur_length = longestPalindromeExHelper(i, 2 + i, s, length);
                if (cur_length > palindrome_length) {
                    palindrome = s.substring(i - cur_length / 2 + 1, i + 2 + cur_length / 2 - 1 + 1);
                    palindrome_length = cur_length;
                }
            }
        }
        return palindrome;
    }

    private int longestPalindromeExHelper(int a, int b, String s, int length) {
        do {
            --a;
            ++b;
        } while (a >= 0 && b < length && s.charAt(a) == s.charAt(b));
        return b - a - 1;
    }

    public static void main(String[] args) {
        String s = "ABCCSTSABASS";
        String palindrome = new Q44_LongestPalindromicSub().longestPalindromeMy(s);
        System.out.println(palindrome);
    }

    public String longestPalindromeMy(String s) {
        int len = s.length(), l = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (i + 2 < len && s.charAt(i) == s.charAt(i + 2)) {
                int radius = longestPalindromeMyHelper(s, i, i + 2);
                if (radius * 2 + 1 > max) {
                    max = radius * 2 + 1;
                    l = i - radius + 1;
                }
            }
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                int radius = longestPalindromeMyHelper(s, i, i + 1);
                if (radius * 2 > max) {
                    max = radius * 2;
                    l = i - radius + 1;
                }
            }
        }
        return s.substring(l, l + max);
    }

    private int longestPalindromeMyHelper(String s, int l, int r) {
        int len = s.length();
        int pre_l = l;
        do {
            --l;
            ++r;
        } while (l >= 0 && r < len && s.charAt(l) == s.charAt(r));
        return pre_l - (l + 1) + 1;
    }
}
