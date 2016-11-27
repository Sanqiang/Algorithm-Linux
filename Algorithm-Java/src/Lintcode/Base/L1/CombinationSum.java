package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CombinationSum {
	/**
	 * @param candidates:
	 *            A list of integers
	 * @param target:An
	 *            integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(results, new ArrayList<Integer>(), 0, target, candidates);
		return results;
	}

	void dfs(List<List<Integer>> results, ArrayList<Integer> result, int pos, int target, int[] candidates) {
		if (target == 0) {
			results.add(new ArrayList<>(result));
		} else if (target < 0) {
			return;
		}

		for (int i = pos; i < candidates.length; i++) {
			if (i >= 1 && candidates[i - 1] == candidates[i]) {
				continue;
			}
			
			for (int cnt = 1; cnt <= target / candidates[i]; cnt++) {
				for (int temp_cnt = 0; temp_cnt < cnt; temp_cnt++) {
					result.add(candidates[i]);
				}
				dfs(results, result, i + 1, target - cnt * candidates[i], candidates);
				for (int temp_cnt = 0; temp_cnt < cnt; temp_cnt++) {
					result.remove(result.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 2,3,4 };
		new CombinationSum().combinationSum(candidates, 5);
	}
}
