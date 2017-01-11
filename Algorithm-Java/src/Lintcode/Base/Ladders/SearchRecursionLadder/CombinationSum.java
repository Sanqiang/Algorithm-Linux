package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * @param candidates:
	 *            A list of integers
	 * @param target:An
	 *            integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<>();
		dfs(candidates, target, results, new ArrayList<Integer>(), 0);
		return results;
	}

	void dfs(int[] candidates, int target, List<List<Integer>> results, List<Integer> result, int cur_i) {
		if (target == 0) {
			results.add(new ArrayList<Integer>(result));
			return;
		} else if (target < 0) {
			return;
		}

		int pre = -1;
		for (int i = cur_i; i < candidates.length; ++i) {
			if (pre != -1 && pre == candidates[i]) {
				continue;
			}
			result.add(candidates[i]);
			dfs(candidates, target - candidates[i], results, result, i);
			result.remove(result.size() - 1);

			pre = candidates[i];
		}
	}
}
