/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q53_MergeSortedArray {

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 0, 0, 0};
        int[] B = {2, 4, 6};
        new Q53_MergeSortedArray().mergeMy(A, 3, B, 3);
        for (int i : A) {
            System.out.println(i);
        }
    }

    public void mergeMy(int A[], int m, int B[], int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (true) {
            if (i < 0) {
                while (j >= 0) {
                    A[k--] = B[j--];
                }
                break;
            } else if (j < 0) {
                while (i >= 0) {
                    A[k--] = A[i--];
                }
                break;
            }

            if (A[i] <= B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
    }
}
