/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q62_PalindromeNumber {

    public boolean isPalindrome1(int x) {
        Wrapper wr = new Wrapper(x);
        return isPalindrome1Helper(x, wr);
    }

    private boolean isPalindrome1Helper(int x, Wrapper wr) {
        if (x == 0) {
            return true;
        }
        if (isPalindrome1Helper(x / 10, wr) && x % 10 == wr.x % 10) {
            wr.x /= 10;
            return true;
        } else {
            return false;
        }
    }

    class Wrapper {

        int x;

        public Wrapper(int _x) {
            this.x = _x;
        }
    }

    public boolean isPalindrome2(int x) {
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int l = (x / div) % 10;
            int r = x % 10;
            if (l != r) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindromeEx(int x) {
        int length = 0;
        int r = x, i;
        while (r > 0) {
            r /= 10;
            ++length;
        }
        for (i = 0; i < length / 2; ++i) {
            if (getDigit(x, i) != getDigit(x, length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private int getDigit(int x, int i) {
        while (i-- > 0) {
            x /= 10;
        }
        return x % 10;
    }

    public static void main(String[] args) {
        int x = 121;
        boolean ispalindrome = new Q62_PalindromeNumber().isPalindromeEx(x);
        System.out.println(ispalindrome);
        boolean ispalindrome2 = new Q62_PalindromeNumber().isPalindrome1(x);
        System.out.println(ispalindrome2);
        boolean ispalindrome3 = new Q62_PalindromeNumber().isPalindrome2(x);
        System.out.println(ispalindrome3);
        boolean ispalindrome4 = new Q62_PalindromeNumber().isPalindromeMy(x);
        System.out.println(ispalindrome4);
    }
    static int num = -1;

    public boolean isPalindromeMy(int x) {
        if ((x > 0 && x < 10) || x == 0) {
            return true;
        }
        if (num == -1) {
            num = x;
        }
        int r = x / 100;
        boolean success = isPalindrome1(r);
        if (num % 10 != r) {
            success &= false;
        }
        num /= 100;
        return success;
    }
}
