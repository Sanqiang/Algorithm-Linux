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
			if (A[i] <= B[j]) {
				smallest = Math.min(smallest, Math.abs(A[i] - B[j]));
				if (i < A.length) {
					++i;
				}
			} else if (A[i] > B[j]) {
				smallest = Math.min(smallest, Math.abs(A[i] - B[j]));
				if (j < B.length) {
					++j;
				}
			}
		}

		return smallest;
	}
}
