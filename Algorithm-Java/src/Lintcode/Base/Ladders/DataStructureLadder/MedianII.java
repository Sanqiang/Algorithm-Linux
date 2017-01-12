package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianII {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: the median of numbers
	 */
	public int[] medianII(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = nums[0];

		PriorityQueue<Integer> max_heap = new PriorityQueue<>(1, Collections.reverseOrder()), min_heap = new PriorityQueue<>();

		for (int i = 1; i < nums.length; ++i) {
			int num = nums[i];

			if (num >= result[i - 1]) {
				min_heap.add(num);
			} else {
				max_heap.add(num);
			}
			result[i] = result[i - 1];
			while (1 + max_heap.size() < min_heap.size()) {
				max_heap.add(result[i]);
				result[i] = min_heap.poll();
			}
			while (max_heap.size() > min_heap.size()) {
				min_heap.add(result[i]);
				result[i] = max_heap.poll();
			}
		}

		return result;
	}
}
