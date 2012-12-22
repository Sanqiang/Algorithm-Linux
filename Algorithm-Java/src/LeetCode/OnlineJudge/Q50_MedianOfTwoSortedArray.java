/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q50_MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int A[], int B[]) {
        int a_length = A.length, b_length = B.length;
        int i = 0, j = 0, count = 0;
        int mid1 = (a_length + b_length) / 2 - ((a_length + b_length) % 2 == 0 ? 1 : 0);
        int mid2 = (a_length + b_length) / 2;
        double median1 = 0, median2 = 0;
        while (count <= mid2) {
            if (i >= a_length) {
                if (count == mid1) {
                    median1 = B[j];
                }
                if (count == mid2) {
                    median2 = B[j];
                }
                ++j;
                ++count;
                continue;
            }
            if (j >= b_length) {
                if (count == mid1) {
                    median1 = A[i];
                }
                if (count == mid2) {
                    median2 = A[i];
                }
                ++i;
                ++count;
                continue;
            }
            if (A[i] >= B[j]) {
                if (count == mid1) {
                    median1 = B[j];
                }
                if (count == mid2) {
                    median2 = B[j];
                }
                ++j;
            } else {
                if (count == mid1) {
                    median1 = A[i];
                }
                if (count == mid2) {
                    median2 = A[i];
                }
                ++i;
            }
            ++count;
        }
        return (median1 + median2) / 2;
    }

    public double findMedianSortedArraysLog(int A[], int B[]) {
        int a_length = A.length, b_length = B.length;
        int length = a_length + b_length;
        if (length % 2 == 0) {
            return findMedianSortedArraysHelper(A, 0, a_length, B, 0, b_length, length / 2) / 2
                    + findMedianSortedArraysHelper(A, 0, a_length, B, 0, b_length, length / 2 + 1) / 2;
        } else {
            return findMedianSortedArraysHelper(A, 0, a_length, B, 0, b_length, length / 2 + 1);
        }
    }

    public double findMedianSortedArraysHelper(int A[], int aoffset, int a_length, int B[], int boffset, int b_length, int k) {
        if (a_length > b_length) {
            return findMedianSortedArraysHelper(B, boffset, b_length, A, aoffset, a_length, k);
        }
        if (a_length == 0) {
            return B[k - 1];
        }
        if (k == 1) {
            return Math.min(A[aoffset], B[boffset]);
        }
        int pa = Math.min(a_length, k / 2);
        int pb = k - pa;

        if (A[aoffset + pa - 1] <= B[boffset + pb - 1]) {
            return findMedianSortedArraysHelper(A, aoffset + pa, a_length - pa, B, boffset, b_length, k - pa);
        } else {
            return findMedianSortedArraysHelper(A, aoffset, a_length, B, boffset + pb, b_length - pb, k - pb);
        }

    }

    public static void main(String[] args) {
        int A[] = {1, 3, 5};
        int B[] = {2, 4, 6};
        double median = new Q50_MedianOfTwoSortedArray().findMedianSortedArrays(A, B);
        System.out.println(median);
        double median2 = new Q50_MedianOfTwoSortedArray().findMedianSortedArraysLog(A, B);
        System.out.println(median2);
    }
}
