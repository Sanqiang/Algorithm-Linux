package Lintcode.Intensive.L6;

public class FirstWillWin {
	/**
	 * @param n:
	 *            an integer
	 * @return: a boolean which equals to true if the first player will win
	 */
	public boolean firstWillWin(int n) {
		boolean[] dp = new boolean[1 + n];
		boolean[] flag = new boolean[1 + n];
		return searchMemory(n, dp, flag);
	}

	boolean searchMemory(int n, boolean[] dp, boolean[] flag) {
		if (flag[n]) {
			return dp[n];
		}
		if (n == 0) {
			dp[n] = false;
		} else if (n == 1 || n == 2) {
			dp[n] = true;
		} else {
			// dp[n] = !searchMemory(n - 1, dp, flag) || !searchMemory(n - 2,
			// dp, flag);
			dp[n] = (searchMemory(n - 2, dp, flag) && searchMemory(n - 3, dp, flag))
					|| (searchMemory(n - 3, dp, flag) && searchMemory(n - 4, dp, flag));
		}
		flag[n] = true;
		return dp[n];
	}

	/**
	 * @param values:
	 *            an array of integers
	 * @return: a boolean which equals to true if the first player will win
	 */
	public boolean firstWillWin2(int[] values) {
		int target = 0;
		for (int i = 0; i < values.length; i++) {
			target += values[i];
		}
		target = (target + 1) / 2;

		int[] dp = new int[values.length + 1];
		boolean[] flag = new boolean[values.length + 1];

		return searchMemory(0, values, dp, flag) > target;
	}

	int searchMemory(int idx, int[] values, int[] dp, boolean[] flag) {
		if (flag[idx]) {
			return dp[idx];
		}
		if (idx == 0) {
			dp[idx] = values[idx];
		} else if (idx == 1) {
			dp[idx] = values[idx] + values[idx + 1];
		} else if (idx == 2) {
			dp[idx] = values[idx + 1] + values[idx + 2];
		} else {
			dp[idx] = Math.max(
					(Math.min(searchMemory(idx - 2, values, dp, flag), searchMemory(idx - 3, values, dp, flag))
							+ values[idx - 1]),
					Math.max(searchMemory(idx - 3, values, dp, flag), searchMemory(idx - 4, values, dp, flag))
							+ values[idx - 1] + values[idx - 2]);
		}
		flag[idx] = true;
		return dp[idx];
	}
}
