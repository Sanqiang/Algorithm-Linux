/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

public class Q17_Division {

    int divison(int divident, int divisor) {
        if (divident == divisor) {
            return 1;
        } else if (divident < divisor) {
            return 0;
        }
        int count = 1;
        while (divident - (count << 1) * divisor >= 0) {
            count <<= 1;
        }
        return divison(divident - count * divisor, divisor) + count;
    }

    public static void main(String[] args) {
        int divident = 12345678;
        int divisor = 4321;
        int result = new Q17_Division().divison(divident, divisor);
        System.out.print(result);
    }
}
