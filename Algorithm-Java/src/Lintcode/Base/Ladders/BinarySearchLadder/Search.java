package Lintcode.Base.Ladders.BinarySearchLadder;

public class Search {
	/**
	 * @param A
	 *            : an integer rotated sorted array
	 * @param target
	 *            : an integer to be searched return : an integer
	 */
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// diff side
			if (target >= A[start] && A[mid] <= A[start]) {
				end = mid;
			} else if (target < A[start] && A[mid] > A[start]) {
				start = mid;
			} else {
				if (A[mid] > target) {
					end = mid;
				} else {
					start = mid;
				}
			}

		}

		if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		} else {
			return -1;
		}
	}
}
