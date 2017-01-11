package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	/**
	 * @param S:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		results.add(new ArrayList<Integer>());
		dfs(nums, 0, results, new ArrayList<Integer>());
		return results;
	}

	void dfs(int[] nums, int cur_i, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result) {
		for (int i = cur_i; i < nums.length; ++i) {
			result.add(nums[i]);
			results.add(new ArrayList<Integer>(result));
			dfs(nums, i + 1, results, result);
			result.remove(result.size() - 1);
		}
	}
}
