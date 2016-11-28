package Lintcode.Base.L2;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {
	/**
	 * @param nums:
	 *            The rotated sorted array
	 * @return: void
	 */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		// find pivot
		int pivot = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i) < nums.get(i - 1)) {
				pivot = i;
			}
		}

		reverse(nums, 0, pivot - 1);
		reverse(nums, pivot, nums.size() - 1);
		reverse(nums, 0, nums.size() - 1);
	}

	void reverse(ArrayList<Integer> nums, int left, int right) {
		while (left < right) {
			int temp = nums.get(left);
			nums.set(left, nums.get(right));
			nums.set(right, temp);
			++left;
			--right;
		}
	}
}
