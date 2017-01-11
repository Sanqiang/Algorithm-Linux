package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permute {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of permutations.
	 */
	public List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		dfs(nums, new HashSet<Integer>(), results, new ArrayList<Integer>());
		return results;
	}

	void dfs(int[] nums, HashSet<Integer> set, List<List<Integer>> results, ArrayList<Integer> result) {
		if(result.size() == nums.length){
			results.add(new ArrayList<Integer>(result));
			return;
		}
		for (int i = 0; i < nums.length; ++i) {
			if (!set.contains(i)) {
				set.add(i);
				result.add(nums[i]);
				dfs(nums, set, results, result);
				result.remove(result.size() - 1);
				set.remove(i);
			}
		}
	}
}
