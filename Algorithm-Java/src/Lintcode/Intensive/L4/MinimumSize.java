package Lintcode.Intensive.L4;

import java.util.Arrays;

public class MinimumSize {
	/**
	 * @param nums:
	 *            an array of integers
	 * @param s:
	 *            an integer
	 * @return: an integer representing the minimum size of subarray
	 */
	public int minimumSize(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0, right = 0, window_sum = 0, min_cnt = Integer.MAX_VALUE;

		for (left = 0; left < nums.length; left++) {
			while (right < nums.length && window_sum < s) {
				window_sum += nums[right];
				++right;
			}
			if (window_sum >= s) {
				if (min_cnt > right - left) {
					min_cnt = right - left;
				}
				window_sum -= nums[left];
			}
		}

		return min_cnt == Integer.MAX_VALUE ? -1 : min_cnt;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2 };
		int min_cnt = new MinimumSize().minimumSize(nums, 7);
		System.out.println(min_cnt);
	}
}
