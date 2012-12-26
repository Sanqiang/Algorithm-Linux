/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q111_TrappingRainWater {

    public int trap(int[] A) {
        int h_val = A[0], h = 0, length = A.length, i;
        for (i = 1; i < length; i++) {
            if (A[i] > h_val) {
                h_val = A[i];
                h = i;
            }
        }
        int water = 0;
        int p = A[0];
        for (i = 1; i < h; ++i) {
            if (A[i] < p) {
                water += p - A[i];
            } else {
                p = A[i];
            }
        }
        p = A[length - 1];
        for (i = length - 2; i > h; --i) {
            if (A[i] < p) {
                water += p - A[i];
            } else {
                p = A[i];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int water = new Q111_TrappingRainWater().trap(A);
        System.out.println(water);
    }
}
