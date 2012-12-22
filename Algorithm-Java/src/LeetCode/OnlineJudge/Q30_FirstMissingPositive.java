/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Q30_FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        int length = A.length, i = 0;
        for (; i < length; ++i) {
            if (A[i] > 0) {
                //A[i] map to i+1
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (i = 0; i < length; ++i) {
            if (A[i] > 0 && A[i] != i + 1) {
                return i + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] A = {6, 4, 3, 1, 2, -1, -3};
        int missing = new Q30_FirstMissingPositive().firstMissingPositive(A);
        System.out.println(missing);
    }
}
