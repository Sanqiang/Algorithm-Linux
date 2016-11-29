package Lintcode.Base.L7;

import java.util.ArrayList;

public class MinSubArray {
	/**
	 * @param nums:
	 *            a list of integers
	 * @return: A integer indicate the sum of minimum subarray
	 */
	public int minSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		int current_min = nums.get(0), min = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			current_min = Math.min(nums.get(i), current_min + nums.get(i));
			min = Math.min(min, current_min);
		}
		return min;
	}
}
