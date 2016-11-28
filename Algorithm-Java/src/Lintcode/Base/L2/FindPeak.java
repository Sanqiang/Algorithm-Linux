package Lintcode.Base.L2;

public class FindPeak {
	/**
	 * @param A:
	 *            An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		int left = 0, right = A.length - 1, peak = -1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] <= A[mid - 1]) {
				right = mid;
			} else if (A[mid] <= A[mid + 1]) {
				left = mid;
			} else {
				peak = mid;
				return peak;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 3, 4, 5, 7, 6 };
		new FindPeak().findPeak(A);
	}
}
