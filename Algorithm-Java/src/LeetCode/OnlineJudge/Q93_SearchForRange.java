/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;

public class Q93_SearchForRange {

    public int[] searchRange(int[] A, int target) {
        int range[] = new int[2], length = A.length;
        range[0] = BinarySearchLow(A, 0, length - 1, target);
        range[1] = BinarySearchHigh(A, 0, length - 1, target);
        return range;
    }

    private int BinarySearchLow(int A[], int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        int v = A[m];
        if (v == target && (m == 0 || A[m - 1] < target)) {
            return m;
        } else if (v < target) {
            return BinarySearchLow(A, m + 1, e, target);
        } else {
            return BinarySearchLow(A, s, m - 1, target);
        }
    }

    private int BinarySearchHigh(int A[], int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        int v = A[m];
        if (v == target && (m == e || A[m + 1] > target)) {
            return m;
        } else if (v > target) {
            return BinarySearchHigh(A, s, m - 1, target);
        } else {
            return BinarySearchHigh(A, m + 1, e, target);
        }
    }

    public int[] searchRangeEx(int[] A, int target) {
        int[] range = new int[2];
        int s = 0, length = A.length, e = length - 1, m = 0;
        while (s < e) {
            m = s + (e - s) / 2;
            if (A[m] < target) {
                s = m + 1;
            } else if (A[m] > target) {
                e = m - 1;
            } else {
                break;
            }
        }
        if (A[m] == target) {
            s = m;
            e = m;
            while (s >= 0 && A[s] == A[m]) {
                --s;
            }
            if (A[m] != A[s]) {
                ++s;
            }
            while (e < length && A[e] == A[m]) {
                ++e;
            }
            if (A[m] != A[e]) {
                --e;
            }
            range[0] = s;
            range[1] = e;
        } else {
            range[0] = -1;
            range[1] = -1;
        }
        return range;
    }

    public static void main(String[] args) {
        int A[] = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10};
        int range[] = new Q93_SearchForRange().searchRangeMy(A, 8);
        System.out.println(range[0] + "," + range[1]);
        int range2[] = new Q93_SearchForRange().searchRange(A, 8);
        System.out.println(range2[0] + "," + range2[1]);

        int test[] = TestUtil.generateArray(99999999, 3, false);
        java.util.Arrays.sort(test);
        long l1 = System.currentTimeMillis();
        int testr1[] = new Q93_SearchForRange().searchRange(test, 1);
        long l2 = System.currentTimeMillis();
        int testr2[] = new Q93_SearchForRange().searchRangeMy(test, 1);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(testr1[0] + "," + testr1[1] + " Cost " + span1);
        System.out.println(testr2[0] + "," + testr2[1] + " Cost " + span2);
    }

    public int[] searchRangeMy(int[] A, int target) {
        int range[] = new int[2], length = A.length;
        range[0] = BinarySearchLowMy(A, 0, length - 1, target);
        range[1] = BinarySearchHighMy(A, 0, length - 1, target);
        return range;
    }

    private int BinarySearchLowMy(int A[], int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (A[m] == target && (m == 0 || A[m - 1] < A[m])) {
            return m;
        } else if (A[m] < target) {
            return BinarySearchLowMy(A, m + 1, e, target);
        } else {
            return BinarySearchLowMy(A, s, m - 1, target);
        }
    }

    private int BinarySearchHighMy(int A[], int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (A[m] == target && (m == A.length - 1 || A[m + 1] > A[m])) {
            return m;
        } else if (A[m] > target) {
            return BinarySearchHighMy(A, s, m - 1, target);
        } else {
            return BinarySearchHighMy(A, m + 1, e, target);
        }
    }
}
