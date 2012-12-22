/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;

public class Q39_JumpGame2 {

    public int jumpEx(int[] A) {
        int length = A.length;
        int[] cache = new int[length];
        int i = 1, j = 0;
        for (; i < length; ++i) {
            cache[i] = Integer.MAX_VALUE;
        }
        cache[0] = 0;
        for (i = 0; i < length; ++i) {
            int pre_dis = cache[i];
            int dis = A[i];
            for (j = 1; j <= dis; ++j) {
                if (i + j < length) {
                    cache[i + j] = Math.min(cache[i + j], 1 + pre_dis); 
                }
            }
        }
        return cache[length - 1];
    }

    public int jump(int[] A) {
        int length = A.length, i = 1, j = 0;
        int[] MinJump = new int[length];
        MinJump[0] = 0;
        int Min = Integer.MAX_VALUE;
        for (; i < length; ++i) {
            Min = Integer.MAX_VALUE;
            for (j = 0; j < i; ++j) {
                if (MinJump[j] >= Min) {
                    continue;
                }
                if (A[j] >= i - j) {
                    Min = Math.min(Min, MinJump[j] + 1);
                }
            }
            MinJump[i] = Min;
        }
        return MinJump[length - 1];
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        int step = new Q39_JumpGame2().jump(A);
        System.out.println(step);
        int step2 = new Q39_JumpGame2().jumpEx(A);
        System.out.println(step2);


        int[] testA = TestUtil.generateArray(99999, 50, false);
        long l1 = System.currentTimeMillis();
        int stepa = new Q39_JumpGame2().jump(testA);
        long l2 = System.currentTimeMillis();
        int stepb = new Q39_JumpGame2().jumpEx(testA);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(stepa + " Cost " + span1);
        System.out.println(stepb + " Cost " + span2);
    }
}
