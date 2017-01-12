package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NthUglyNumber {
	/**
	 * @param n
	 *            an integer
	 * @return the nth prime number as description.
	 */
	public int nthUglyNumber(int n) {
		if (n == 1) {
			return 1;
		}

		HashSet<Long> check = new HashSet<>();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long last = 1;
		check.add(1l);
		for (int i = 1; i < n; ++i) {
			if (!check.contains(last * 2)) {
				pq.add(last * 2);
				check.add(last * 2);
			}
			if (!check.contains(last * 3)) {
				pq.add(last * 3);
				check.add(last * 3);
			}
			if (!check.contains(last * 5)) {
				pq.add(last * 5);
				check.add(last * 5);
			}

			last = pq.poll();
		}

		return (int) last;
	}

	public int nthUglyNumber2(int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;

		for (int i = 1; i < n; ++i) {
			int last = nums[i - 1];
			while (2 * nums[p2] <= last) {
				++p2;
			}
			while (3 * nums[p3] <= last) {
				++p3;
			}
			while (5 * nums[p5] <= last) {
				++p5;
			}

			nums[i] = Math.min(Math.min(5 * nums[p5], 3 * nums[p3]), 2 * nums[p2]);
		}

		return nums[n - 1];
	}
}
