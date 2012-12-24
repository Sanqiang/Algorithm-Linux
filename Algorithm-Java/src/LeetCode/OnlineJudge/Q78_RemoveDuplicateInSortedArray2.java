/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q78_RemoveDuplicateInSortedArray2 {

    public int removeDuplicates(int[] A) {
        int length = A.length, i, j = 0, count = 1;
        for (i = 1; i < length; i++) {
            if (A[i] == A[i - 1]) {
                if (count < 2) {
                    ++count;
                }
            } else {
                if (count == 1) {
                    A[j++] = A[i - 1];
                } else if (count == 2) {
                    A[j++] = A[i - 1];
                    A[j++] = A[i - 1];
                }
                count = 1;
            }
        }
        if (count == 1) {
            A[j++] = A[i - 1];
        } else if (count == 2) {
            A[j++] = A[i - 1];
            A[j++] = A[i - 1];
        }
        return j;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4};
        int length = new Q78_RemoveDuplicateInSortedArray2().removeDuplicates(A);
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println("len:" + length);
    }
}
