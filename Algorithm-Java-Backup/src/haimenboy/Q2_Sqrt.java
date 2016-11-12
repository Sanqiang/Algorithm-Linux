/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

public class Q2_Sqrt {

    final double precision = 0.000001;

    public double sqrt(double num) {
        if (num < 0) {
            return -1;
        } else if (num == 0 || num == 1) {
            return num;
        }
        double s = 0, e = num;
        while (e - s > precision) {
            double m = s + (e - s) / 2;
            double sqaure = m * m;
            if (sqaure == num) {
                return m;
            } else if (sqaure > num) {
                e = m;
            } else {
                s = m;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        double num = 3;
        double sqpt = new Q2_Sqrt().sqrt(num);
        System.out.println(sqpt);
    }
}
