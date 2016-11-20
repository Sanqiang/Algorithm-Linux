package Lintcode.Intensive.L3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: The maximum number inside the window at each moving.
	 */
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>(nums.length - k + 1);
		if (nums == null || nums.length == 0) {
			return result;
		}else if(nums.length == 1){
			result.add(nums[0]);
			return result;
		}
		
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			while (deque.peekLast() < nums[i]) {
				deque.removeLast();
			}
			deque.addLast(nums[i]);
			
			if (i >= k -1) {
				result.add(deque.peekLast());
			}
			
			if (deque.peekFirst() == nums[i - k]) {
				deque.removeFirst();
			}
		}

		return result;
	}
}
