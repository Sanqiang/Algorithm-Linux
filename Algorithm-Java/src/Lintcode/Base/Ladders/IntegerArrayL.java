package Lintcode.Base.Ladders;

public class IntegerArrayL {
	/**
	 * @param A:
	 *            A list of integers
	 * @param elem:
	 *            An integer
	 * @return: The new length after remove
	 */
	public int removeElement(int[] A, int elem) {
		int idx = 0;

		int left = 0, right = 0;
		while (true) {
			while (left < A.length) {
				if (A[left] == elem) {
					right = left;
				}
				++left;
			}
			while (right < A.length) {
				if (A[right] != elem) {
					int temp = A[left];
					A[left] = A[right];
					A[right] = temp;
				}
				++right;
			}
		}
	}
}
