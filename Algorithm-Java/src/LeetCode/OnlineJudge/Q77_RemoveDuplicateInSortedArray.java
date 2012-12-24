/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

public class Q77_RemoveDuplicateInSortedArray {

    public int removeDuplicates(int[] A) {
        int length = A.length, i, j = 0;
        for (i = 1; i < length; i++) {
            if (A[i] != A[i - 1]) {
                A[++j] = A[i];
            }
        }
        A[++j] = A[i - 1];
        return j;
    }

    public static void main(String[] args) {
        int A[] = {1, 1, 1, 2, 2, 3, 3, 3};
        int length = new Q77_RemoveDuplicateInSortedArray().removeDuplicates(A);
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println("len:" + length);
    }
}
