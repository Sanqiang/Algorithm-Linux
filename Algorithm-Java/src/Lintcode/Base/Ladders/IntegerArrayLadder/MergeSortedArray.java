package Lintcode.Base.Ladders.IntegerArrayLadder;

public class MergeSortedArray {
	/**
	 * @param A:
	 *            sorted integer array A which has m elements, but size of A is
	 *            m+n
	 * @param B:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int i = m - 1, j = n -1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] >= B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}
		while(j >= 0){
			A[k--] = B[j--];
		}
	}

	/**
	 * @param A
	 *            and B: sorted integer array A and B.
	 * @return: A new sorted integer array
	 */
	public int[] mergeSortedArray(int[] A, int[] B) {
		int[] result = new int[A.length + B.length];

		int i = 0, j = 0, k = 0;
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				result[k++] = A[i++];
			} else {
				result[k++] = B[j++];
			}
		}
		while (i < A.length) {
			result[k++] = A[i++];
		}
		while (j < B.length) {
			result[k++] = B[j++];
		}

		return result;
	}
}
