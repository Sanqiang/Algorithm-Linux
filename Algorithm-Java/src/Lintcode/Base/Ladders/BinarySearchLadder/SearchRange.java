package Lintcode.Base.Ladders.BinarySearchLadder;

public class SearchRange {
	/**
	 * @param A
	 *            : an integer sorted array
	 * @param target
	 *            : an integer to be inserted return : a list of length 2,
	 *            [index1, index2]
	 */
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (A == null || A.length == 0) {
			return result;
		}

		// find start
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (A[start] == target) {
			result[0] = start;
		} else if (A[end] == target) {
			result[0] = end;
		}

		// find last
		start = 0;
		end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (A[end] == target) {
			result[1] = end;
		} else if (A[start] == target) {
			result[1] = start;
		}

		return result;
	}
}
