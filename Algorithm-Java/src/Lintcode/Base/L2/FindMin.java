package Lintcode.Base.L2;

public class FindMin {
	/**
	 * @param nums:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0, right = nums.length - 1, target = nums[nums.length - 1];
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return Math.min(nums[left], nums[right]);
	}

	/**
	 * @param num:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0, right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == nums[right]) {
				--right;
			} else if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return Math.min(nums[left], nums[right]);
	}
}
