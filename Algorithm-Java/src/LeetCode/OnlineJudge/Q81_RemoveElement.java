/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;

public class Q81_RemoveElement {

    public int removeElement(int[] A, int elem) {
        int s = 0, length = A.length, e = length - 1;
        while (s < e) {
            for (; s < e && A[s] != elem; ++s);
            for (; s < e && A[e] == elem; --e);
            int temp = A[s];
            A[s] = A[e];
            A[e] = temp;
        }
        return s;
    }

    public int removeElementEx(int[] A, int elem) {
        int length = A.length, i, j = 0;
        for (i = 0; i < length; i++) {
            if (A[i] != elem) {
                A[j++] = A[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 2, 3, 4, 3, 5, 6, 3};
        int len = new Q81_RemoveElement().removeElementMy(A, 3);
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println("len:" + len);

        int test[] = TestUtil.generateArray(99999999, 9, false);
        long l1 = System.currentTimeMillis();
        int t1 = new Q81_RemoveElement().removeElement(test, 5);
        long l2 = System.currentTimeMillis();
        int t2 = new Q81_RemoveElement().removeElementEx(test, 5);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(t1 + " Cost " + span1);
        System.out.println(t2 + " Cost " + span2);
    }

    public int removeElementMy(int[] A, int elem) {
        int len = A.length, pos = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[pos++] = A[i];
            }
        }
        return pos;
    }
}
