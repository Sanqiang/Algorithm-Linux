package Lintcode.Base.Ladders.IntegerArrayLadder;

public class RemoveElement {
	/**
	 * @param A:
	 *            A list of integers
	 * @param elem:
	 *            An integer
	 * @return: The new length after remove
	 */
	public int removeElement(int[] A, int elem) {
		int true_idx = 0, loop_idx = 0;
		while (loop_idx < A.length) {
			if (loop_idx != true_idx) {
				int temp = A[loop_idx];
				A[loop_idx] = A[true_idx];
				A[true_idx] = temp;
			}

			++loop_idx;
			while (loop_idx < A.length && A[loop_idx] == elem) {
				++loop_idx;
			}
			if(A[true_idx] != elem){
				++true_idx;
			}
			
		}
		
		return true_idx;
	}
}
