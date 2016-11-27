package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	/**
	 * @param S:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return results;
		}
		Arrays.sort(nums);
		dfs(results, new ArrayList<Integer>(), 0, nums);
		return results;
	}

	void dfs(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int idx, int[] nums) {
		results.add(new ArrayList<>(result));

		for (int i = idx; i < nums.length; i++) {
			result.add(nums[i]);
			int result_size = result.size();
			dfs(results, result, i + 1, nums);
			result.remove(result_size - 1);
		}
	}

	/**
	 * @param nums:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return results;
		}
		Arrays.sort(nums);
		dfs2(results, new ArrayList<Integer>(), 0, nums);
		return results;
	}
	
	void dfs2(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int idx, int[] nums) {
		results.add(new ArrayList<>(result));

		for (int i = idx; i < nums.length; i++) {
			if (i >= 1 && nums[i - 1] == nums[i] && i > idx) {
				continue;
			}
			result.add(nums[i]);
			int result_size = result.size();
			dfs2(results, result, i + 1, nums);
			result.remove(result_size - 1);
		}
	}

}
