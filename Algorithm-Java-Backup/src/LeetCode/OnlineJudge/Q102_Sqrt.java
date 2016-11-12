/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q102_Sqrt {

    final double precis = 0.00001;

    public double sqrt(double x) {
        double s = 0, e = x, m = x / 2;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (m * m > x) {
                e = m - 1;
            } else if (m * m < x) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return m;
    }

    public double sqrt2(double x) {
        double m = x / 2, entropy = x / 2;
        while (entropy > precis) {
            if (m * m < x) {
                m += entropy;
            } else if (m * m > x) {
                m -= entropy;
            } else {
                return m;
            }
            entropy /= 2;
        }
        return m;
    }

    public double sqrtNewton(double n) {
        double x = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x = (x + n / 2) / 2;
        }
        return x;
    }

    public static void main(String[] args) {
        double val = 3;
        double sqt = new Q102_Sqrt().sqrt2(val);
        System.out.println(sqt);

        double binary = new Q102_Sqrt().sqrt(val);
        System.out.println(binary);

        double my = new Q102_Sqrt().sqrtMy(val);
        System.out.println(my);

        /*
         double newton = new Q102_Sqrt().sqrtNewton(val);
         System.out.println(newton);
         */
    }

    public double sqrtMy(double x) {
        double num = x / 2;
        double dif = x / 4;
        while (true) {
            if (Math.abs(num * num - x) <= precis) {
                return num;
            } else if (num * num > x) {
                num -= dif;
            } else if (num * num < x) {
                num += dif;
            }
            dif /= 2;
        }
    }
}
