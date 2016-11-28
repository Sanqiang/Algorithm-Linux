package Lintcode.Base.L2;

public class SearchInsert {
	/**
	 * param A : an integer sorted array param target : an integer to be
	 * inserted return : an integer
	 */
	public int searchInsert(int[] A, int target) {
		int left = 0, right = A.length - 1;
		if (A == null || A.length == 0) {
			return -1;
		}

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				right = mid;
			} else if (A[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		if (A[left] >= target && A[right] >= target) {
			return left;
		} else if (A[left] < target && A[right] < target) {
			return right + 1;
		} else {
			return right;
		}
	}
}
