/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

public class Q49_MaxSubarray {

    public int maxSubArray(int[] A) {
        int i, length = A.length, cur = 0;
        int max = Integer.MIN_VALUE;
        for (i = 0; i < length; ++i) {
            cur += A[i];
            if (cur < 0) {
                max = Math.max(max, cur - A[i]);
                cur = 0;
            }
        }
        max = Math.max(max, cur);
        if (max <= 0) {
            max = Integer.MIN_VALUE;
            for (i = 0; i < length; ++i) {
                max = Math.max(max, A[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, -2};
        int max = new Q49_MaxSubarray().maxSubArrayMy(A);
        System.out.println(max);
    }

    //my way
    public int maxSubArrayMy(int[] A) {
        int max = 0, len = A.length, count = 0;;
        for (int i = 0; i < len; i++) {
            count += A[i];
            if (count < 0) {
                count = 0;
            } else {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
