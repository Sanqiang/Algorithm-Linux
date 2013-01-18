/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package LeetCode.OnlineJudge;

public class Q28_DivideTwoIntegers {

    int divide(int dividend, int divisor) {
        boolean neg = false;
        if (dividend < 0) {
            neg = !neg;
            dividend = toPos(dividend);
        }
        if (divisor < 0) {
            neg = !neg;
            divisor = toPos(divisor);
        }
        return divideHelper(dividend, divisor) * (neg ? -1 : 1);

    }

    int divideHelper(int dividend, int divisor) {
        if (dividend < divisor) {
            return 0;
        } else if (dividend == divisor) {
            return 1;
        }
        /*
         if (dividend <= (divisor >> 1)) {
         System.out.println("OverFlow");
         return 0;
         }
         if ((divisor << 1) <= divisor) {
         System.out.println("OverFlow");
         return 0;
         }
         */
        int bit_count = 0;
        int temp = divisor;
        while (dividend > (temp << 1)) {
            ++bit_count;
            temp <<= 1;
            /*if ((temp << 1) <= temp) {
             System.out.println("OverFlow");
             //break;
             }*/
        }
        return divide(dividend - temp, divisor) + (1 << bit_count);
    }

    int toPos(int n) {
        return ~n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Q28_DivideTwoIntegers().toPos(100));
        int divident = 10;
        int divisor = 3;
        int result = new Q28_DivideTwoIntegers().divideMy(divident, divisor);
        System.out.println(result);
        System.out.println("Sample:" + divident / divisor);
    }

    //my way
    int divideMy(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        } else if (dividend < divisor) {
            return 0;
        }
        int count = 0;
        int temp = divisor;
        while (dividend > (temp << 1)) {
            temp <<= 1;
            count++;
        }
        return (1 << count) + divideMy(dividend - temp, divisor);
    }
}
