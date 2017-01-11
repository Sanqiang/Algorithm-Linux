package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.List;

public class Combine {
	/**
	 * @param n:
	 *            Given the range of numbers
	 * @param k:
	 *            Given the numbers of combinations
	 * @return: All the combinations of k numbers out of 1..n
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();
		dfs(n, k, results, new ArrayList<Integer>(), 0);
		return results;
	}

	void dfs(int n, int k, List<List<Integer>> results, List<Integer> result, int cur_i) {
		if (result.size() == k) {
			results.add(new ArrayList<Integer>(result));
			return;
		}

		for (int i = 1 + cur_i; i <= n; ++i) {
			result.add(i);
			dfs(n, k, results, result, i);
			result.remove(result.size() - 1);
		}
	}
}
