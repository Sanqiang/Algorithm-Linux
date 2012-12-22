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

    public String longestPalindrome(String s) {
        int length = s.length(), i = 0;
        return "";
    }

    public static void main(String[] args) {
        String s = "ABCCSSABASS";
        String palindrome = new Q44_LongestPalindromicSub().longestPalindromeEx(s);
        System.out.println(palindrome);
    }
}
