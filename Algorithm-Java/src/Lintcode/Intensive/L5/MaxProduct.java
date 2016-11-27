package Lintcode.Intensive.L5;

public class MaxProduct {
	/**
	 * @param nums:
	 *            an array of integers
	 * @return: an integer
	 */
	public int maxProduct(int[] nums) {
		int pre_current_max = Math.max(1, nums[0]), max = nums[0], current_max = 0;
		int pre_current_min = Math.min(1, nums[0]), min = nums[0], current_min = 0;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] > 0) {
				current_max = Math.max(nums[i], pre_current_max * nums[i]);
				current_min = Math.min(nums[i], pre_current_min * nums[i]);
			} else if (nums[i] < 0) {
				current_max = Math.max(nums[i], pre_current_min * nums[i]);
				current_min = Math.min(nums[i], pre_current_max * nums[i]);
			}
			max = Math.max(max, current_max);
			min = Math.min(min, current_min);
			pre_current_min = current_min;
			pre_current_max = current_max;
		}

		return max;
	}
}
