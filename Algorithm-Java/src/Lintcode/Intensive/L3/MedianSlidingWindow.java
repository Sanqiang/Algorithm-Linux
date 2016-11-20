package Lintcode.Intensive.L3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k / 2, Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k / 2);

		int median = nums[0];
		for (int i = 1; i < nums.length; i++) {

			if (i >= k) {
				if (minHeap.contains(nums[i - k])) {
					minHeap.remove(nums[i - k]);
				} else if (maxHeap.contains(nums[i - k])) {
					maxHeap.remove(nums[i - k]);
				}
			}
			if (nums[i] >= median) {
				maxHeap.offer(nums[i]);
			} else {
				minHeap.offer(nums[i]);
			}
			if (maxHeap.size() > 1 + minHeap.size()) {
				minHeap.add(median);
				median = maxHeap.poll();
			} else if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(median);
				median = minHeap.poll();
			}

			if (i >= k - 1) {
				result.add(median);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ArrayList<Integer> result = new MedianSlidingWindow().medianSlidingWindow(nums, 3);
		for (Integer median : result) {
			System.out.println(median);
		}
	}
}
