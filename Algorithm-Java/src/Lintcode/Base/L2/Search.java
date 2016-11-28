package Lintcode.Base.L2;

import com.sun.accessibility.internal.resources.accessibility;

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
		int left = 0, right = A.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[left] < A[mid]) {
				if (target >= A[left] && target <= A[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (target >= A[mid] && target <= A[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}

		if (target == A[left]) {
			return left;
		} else if (target == A[right]) {
			return right;
		} else {
			return -1;
		}
	}

	/**
	 * param A : an integer ratated sorted array and duplicates are allowed
	 * param target : an integer to be search return : a boolean
	 */
	public boolean search2(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return true;
			}
		}
		return false;
	}
}
