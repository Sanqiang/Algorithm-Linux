package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.Stack;

public class LargestRectangleArea {
	/**
	 * @param height:
	 *            A list of integer
	 * @return: The area of largest rectangle in the histogram
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int max_area = height[0];
		for (int i = 1; i < height.length; ++i) {
			if (height[i] >= height[i - 1]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int h = height[stack.pop()];
					int w = stack.isEmpty() ? i : (i - 1 - stack.peek());
					max_area = Math.max(max_area, h * w);
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int h = height[stack.pop()];
			int w = stack.isEmpty() ? (height.length) : (height.length - 1 - stack.peek());
			max_area = Math.max(max_area, h * w);
		}

		return max_area;
	}
}
