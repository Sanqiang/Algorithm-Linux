/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package Util;

import java.util.Calendar;
import java.util.Random;

public class TestUtil {

    public static int[] generateArray(int n) {
        return generateArray(n, 100, true);
    }

    public static int[] generateArray(int n, int max, boolean negative) {
        int[] arr = new int[n];
        Random r = new Random(Calendar.getInstance().MILLISECOND);
        for (int i = 0; i < n; i++) {
            int current = r.nextInt(max);
            if (negative) {
                current -= max / 2;
            }
            arr[i] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
    }
}
