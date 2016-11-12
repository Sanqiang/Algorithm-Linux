/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

public class Q38_JumpGame {

    public boolean canJump(int[] A) {
        int length = A.length, i = 0, j = 0;
        for (; i < length; ++i) {
            if (A[i] == 0) {
                boolean pass = false;
                for (j = i - 1; j >= 0; --j) {
                    if (A[j] > i - j) {
                        pass = true;
                        break;
                    }
                    if (!pass) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 2, 0, 4};
        boolean result = new Q38_JumpGame().canJumpMy(A);
        System.out.println(result);
    }

    //my way
    public boolean canJumpMy(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                boolean pass = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (i - j < A[j]) {
                        pass = true;
                        break;
                    }
                }
                if (!pass) {
                    return false;
                }
            }
        }
        return true;
    }
}
