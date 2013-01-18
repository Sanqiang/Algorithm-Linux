/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

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
        int missing = new Q30_FirstMissingPositive().firstMissingPositiveMy(A);
        System.out.println(missing);
    }

    //my way
    public int firstMissingPositiveMy(int[] A) {
        int len = A.length;
        boolean[] helper = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (A[i] > 0) {
                helper[A[i]] = true;
            }
        }
        for (int i = 1; i < len; i++) {
            if (!helper[i]) {
                return i;
            }
        }
        return -1;
    }
}
