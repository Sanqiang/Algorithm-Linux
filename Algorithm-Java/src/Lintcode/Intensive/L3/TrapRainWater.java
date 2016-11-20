package Lintcode.Intensive.L3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapRainWater {
	/**
	 * @param heights:
	 *            an array of integers
	 * @return: a integer
	 */
	public int trapRainWater(int[] heights) {
		int sum = 0;
		if (heights == null || heights.length == 0) {
			return sum;
		}

		int left = 0, right = heights.length - 1, previous_left_height = heights[left],
				previous_right_height = heights[right];
		while (left < right) {
			if (heights[left] < heights[right]) {
				++left;
				if (heights[left] < previous_left_height) {
					sum += previous_left_height - heights[left];
				} else {
					previous_left_height = heights[left];
				}
			} else {
				--right;
				if (heights[right] < previous_right_height) {
					sum += previous_right_height - heights[right];
				} else {
					previous_right_height = heights[right];
				}
			}

		}

		return sum;
	}

	class RectEntry {
		public int x, y, val;

		public RectEntry(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	class RectComparator implements Comparator<RectEntry> {

		@Override
		public int compare(RectEntry o1, RectEntry o2) {
			return o1.val - o2.val;
		}

	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}

		int sum = 0, m = heightMap.length, n = heightMap[0].length;

		boolean[][] visited = new boolean[m][n];
		PriorityQueue<RectEntry> queue = new PriorityQueue<RectEntry>(new RectComparator());

		for (int i = 0; i < n; i++) {
			queue.add(new RectEntry(0, i, heightMap[0][i]));
			queue.add(new RectEntry(m - 1, i, heightMap[m - 1][i]));
			visited[0][i] = true;
			visited[m - 1][i] = true;
		}
		for (int i = 0; i < m; i++) {
			queue.add(new RectEntry(i, 0, heightMap[i][0]));
			queue.add(new RectEntry(i, n - 1, heightMap[i][n - 1]));
			visited[i][0] = true;
			visited[i][n - 1] = true;
		}

		while (!queue.isEmpty()) {
			RectEntry temp = queue.poll();
			if (temp.x - 1 >= 0 && !visited[temp.x - 1][temp.y]) {
				if (heightMap[temp.x - 1][temp.y] < temp.val) {
					sum += temp.val - heightMap[temp.x - 1][temp.y];
				}
				queue.add(new RectEntry(temp.x - 1, temp.y, Math.max(heightMap[temp.x - 1][temp.y], temp.val)));
				visited[temp.x - 1][temp.y] = true;
			}
			if (temp.x + 1 < m && !visited[temp.x + 1][temp.y]) {
				if (heightMap[temp.x + 1][temp.y] < temp.val) {
					sum += temp.val - heightMap[temp.x + 1][temp.y];
				}
				queue.add(new RectEntry(temp.x + 1, temp.y, Math.max(heightMap[temp.x + 1][temp.y], temp.val)));
				visited[temp.x + 1][temp.y] = true;
			}
			if (temp.y - 1 >= 0 && !visited[temp.x][temp.y - 1]) {
				if (heightMap[temp.x][temp.y - 1] < temp.val) {
					sum += temp.val - heightMap[temp.x][temp.y - 1];
				}
				queue.add(new RectEntry(temp.x, temp.y - 1, Math.max(heightMap[temp.x][temp.y - 1], temp.val)));
				visited[temp.x][temp.y - 1] = true;
			}
			if (temp.y + 1 < n && !visited[temp.x][temp.y + 1]) {
				if (heightMap[temp.x][temp.y + 1] < temp.val) {
					sum += temp.val - heightMap[temp.x][temp.y + 1];
				}
				queue.add(new RectEntry(temp.x, temp.y + 1, Math.max(heightMap[temp.x][temp.y + 1], temp.val)));
				visited[temp.x][temp.y + 1] = true;
			}

		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		int sum = new TrapRainWater().trapRainWater(heightMap);
		System.out.println(sum);
	}
}
