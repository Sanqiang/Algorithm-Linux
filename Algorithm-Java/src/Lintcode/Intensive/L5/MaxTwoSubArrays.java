package Lintcode.Intensive.L5;

import java.util.ArrayList;

public class MaxTwoSubArrays {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(int[] nums) {
		int current_max = Math.max(0, nums[0]), max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			current_max = Math.max(nums[i], nums[i] + current_max);
			max = Math.max(max, current_max);
		}

		return max;
	}

	/**
	 * @param nums:
	 *            A list of integers
	 * @return: An integer denotes the sum of max two non-overlapping subarrays
	 */
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		int[] left_current_max = new int[nums.size()], left_max = new int[nums.size()];
		left_max[0] = nums.get(0);
		left_current_max[0] = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			left_current_max[i] = Math.max(nums.get(i), left_current_max[i - 1] + nums.get(i));
			left_max[i] = Math.max(left_max[i - 1], left_current_max[i]);
		}

		int[] right_current_max = new int[nums.size()], right_max = new int[nums.size()];
		right_current_max[nums.size() - 1] = nums.get(nums.size() - 1);
		right_max[nums.size() - 1] = nums.get(nums.size() - 1);
		for (int i = nums.size() - 2; i >= 0; i--) {
			right_current_max[i] = Math.max(nums.get(i), right_current_max[i + 1] + nums.get(i));
			right_max[i] = Math.max(right_max[i + 1], right_current_max[i]);
		}

		int max_value = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size() - 1; i++) {
			max_value = Math.max(left_max[i] + right_max[i + 1], max_value);
		}

		return max_value;
	}

	/**
	 * @param nums:
	 *            A list of integers
	 * @param k:
	 *            An integer denote to find k non-overlapping subarrays
	 * @return: An integer denote the sum of max k non-overlapping subarrays
	 */
	public int maxSubArray(int[] nums, int k) {
		
		//todo not finished backpack
		int len = nums.length;
		int[][] current_max = new int[len][len];
		int[][] global_max = new int[len][len];

		for (int i = 0; i < len; i++) {
			current_max[i][0] = nums[i];
			global_max[i][0] = nums[i];
			for (int j = i + 1; j < len; j++) {
				current_max[i][j] = Math.max(current_max[i][j - 1], current_max[i][j - 1] + nums[j]);
				global_max[i][j] = Math.max(current_max[i][j], global_max[i][j - 1]);
			}
		}

		int max_value = Integer.MIN_VALUE;
		
		
		return max_value;
	}
}
