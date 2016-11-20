package Lintcode.Intensive.L3;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianII {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: the median of numbers
	 */
	public int[] medianII(int[] nums) {
        int[] results = new int[nums.length];

		PriorityQueue<Integer> smallerStack = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder()), largerStack = new PriorityQueue<Integer>();

		results[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= results[i - 1]) {
				largerStack.add(nums[i]);
			} else {
				smallerStack.add(nums[i]);
			}
			results[i] = results[i - 1];

			// adjust
			if (smallerStack.size() + 1 < largerStack.size()) {
				while (smallerStack.size() + 1 < largerStack.size()) {
					smallerStack.add(results[i]);
					results[i] = largerStack.poll();
				}
			} else if (smallerStack.size() - 1 >= largerStack.size()) {
				while (smallerStack.size() + 1 > largerStack.size()) {
					largerStack.add(results[i]);
					results[i] = smallerStack.poll();
				}
			}
		}

		return results;
	}
}
