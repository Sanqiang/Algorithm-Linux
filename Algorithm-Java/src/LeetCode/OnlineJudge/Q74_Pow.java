/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

public class Q74_Pow {

    public double pow(double x, int n) {
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (neg) {
            return 1 / result;
        } else {
            return result;
        }
    }

    public double powBinary(double x, int n) {
        if (n < 0) {
            return 1 / powBinaryHelper(x, -n);
        } else {
            return powBinaryHelper(x, n);
        }
    }

    public double powBinaryHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double val = powBinaryHelper(x, n / 2);
        if (n % 2 == 0) {
            return val * val;
        } else {
            return val * val * x;
        }
    }

    public static void main(String[] args) {
        double result = new Q74_Pow().pow(2, 10);
        double result2 = new Q74_Pow().powBinary(2, 4);
        System.out.println(result);
        System.out.println(result2);
    }
}
