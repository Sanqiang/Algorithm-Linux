package Lintcode.Base.L1;

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
		dfs(results, new ArrayList<Integer>(), n, k, 1);
		return results;
	}

	void dfs(List<List<Integer>> results, ArrayList<Integer> result, int n, int k, int idx) {
		if (result.size() == k) {
			results.add(new ArrayList<>(result));
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			result.add(i);
			dfs(results, result, n, k, 1 + i);
			result.remove(result.size() - 1);
		}
	}
}
