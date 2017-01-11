package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.HashSet;

public class LongestConsecutive {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return an integer
	 */
	public int longestConsecutive(int[] num) {
		int long_len = 0;
		HashSet<Integer> checker = new HashSet<>();
		for (int n : num) {
			checker.add(n);
		}

		for (int n : num) {
			int len = 1;
			int loop = n - 1;
			while (checker.contains(loop)) {
				checker.remove(loop);
				loop -= 1;
				++len;
			}
			loop = n + 1;
			while (checker.contains(loop)) {
				checker.remove(loop);
				loop += 1;
				++len;
			}

			long_len = Math.max(long_len, len);
		}

		return long_len;
	}
}
