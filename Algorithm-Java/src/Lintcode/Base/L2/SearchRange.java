package Lintcode.Base.L2;

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

		// lower bound
		int left = 0, right = A.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				right = mid;
			} else if (A[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (A[left] == target) {
			result[0] = left;
		}else if(A[right] == target){
			result[0] = right;
		}else{
			result[0] = result[1] = -1;
			return result;
		}
		

		// upper bound
		left = 0;
		right = A.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				left = mid;
			} else if (A[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (A[right] == target) {
			result[1] = right;
		}else if(A[left] == target){
			result[1] = left;
		}else{
			result[0] = result[1] = -1;
			return result;
		}
		
		return result;
	}
}
