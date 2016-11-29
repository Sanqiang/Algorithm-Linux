package Lintcode.Base.L7;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		int len = nums.length;

		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];

			if (map.containsKey(sum)) {
				ans.add(map.get(sum) + 1);
				ans.add(i);
				return ans;
			}

			map.put(sum, i);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -3, 1, 2, -3, 4 };
		new SubarraySum().subarraySum(nums);
	}
}
