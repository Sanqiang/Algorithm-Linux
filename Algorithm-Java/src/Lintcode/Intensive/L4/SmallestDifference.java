package Lintcode.Intensive.L4;

import java.util.Arrays;

public class SmallestDifference {
	/**
	 * @param A,
	 *            B: Two integer arrays.
	 * @return: Their smallest difference.
	 */
	public int smallestDifference(int[] A, int[] B) {
		int smallest = Integer.MAX_VALUE;

		Arrays.sort(A);
		Arrays.sort(B);

		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if ((j == B.length && i < A.length) || A[i] <= A[j]) {
				smallest = Math.min(smallest, Math.abs(A[i] - B[j]));
				++i;
			} else if ((i == A.length && j < B.length) || A[i] > A[j]) {
				smallest = Math.min(smallest, Math.abs(A[i] - B[j]));
				++j;
			}
		}

		return smallest;
	}
}
