/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q84_ReverseInteger {

    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            x = -x;
            neg = true;
        }
        int solution = 0;
        while (x > 0) {
            int d = x % 10;
            solution *= 10;
            solution += d;
            x = x / 10;
        }
        return solution;
    }

    public static void main(String[] args) {
        int solution = new Q84_ReverseInteger().reverseMy(-12345);
        System.out.println(solution);
    }

    public int reverseMy(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int num = 0;
        while (x > 0) {
            num *= 10;
            num += x % 10;
            x /= 10;
        }
        if (neg) {
            num *= -1;
        }
        return num;
    }
}
