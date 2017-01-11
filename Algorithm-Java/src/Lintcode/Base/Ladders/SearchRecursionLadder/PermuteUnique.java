package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermuteUnique {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of unique permutations.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		dfs(nums, new HashSet<Integer>(), results, new ArrayList<Integer>());
		return results;
	}

	void dfs(int[] nums, HashSet<Integer> set, List<List<Integer>> results, ArrayList<Integer> result) {
		if (result.size() == nums.length) {
			results.add(new ArrayList<Integer>(result));
			return;
		}
		int pre = -99999;
		for (int i = 0; i < nums.length; ++i) {
			if (pre != -99999 && pre == nums[i]) {
				continue;
			}

			if (!set.contains(i)) {
				set.add(i);
				result.add(nums[i]);
				dfs(nums, set, results, result);
				result.remove(result.size() - 1);
				set.remove(i);
			}

			pre = nums[i];
		}
	}
}
