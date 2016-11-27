package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of permutations.
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) {
			return results;
		}
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		dfs(results, new ArrayList<Integer>(), nums, visited);
		return results;
	}

	void dfs(List<List<Integer>> results, ArrayList<Integer> result, int[] nums, boolean[] visited) {
		if (result.size() == nums.length) {
			results.add(new ArrayList<>(result));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			result.add(nums[i]);
			visited[i] = true;
			dfs(results, result, nums, visited);
			result.remove(result.size() - 1);
			visited[i] = false;
		}
	}

	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of unique permutations.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) {
			return results;
		}
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		dfs2(results, new ArrayList<Integer>(), visited, nums);
		return results;
	}

	void dfs2(List<List<Integer>> results, ArrayList<Integer> result,boolean[] visited, int[] nums) {
		if (result.size() == nums.length) {
			results.add(new ArrayList<>(result));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if ((i >= 1 && nums[i - 1] == nums[i] && !visited[i - 1]) || visited[i]) {
				continue;
			}
			result.add(nums[i]);
			visited[i] = true;
			dfs2(results, result, visited, nums);
			result.remove(result.size() - 1);
			visited[i] = false;
		}
	}
}
