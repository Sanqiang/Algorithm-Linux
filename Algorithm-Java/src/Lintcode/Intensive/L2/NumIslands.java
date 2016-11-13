package Lintcode.Intensive.L2;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Lintcode.Util.UnionFind;
import javafx.beans.property.BooleanProperty;

public class NumIslands {
	/**
	 * @param grid
	 *            a boolean 2D matrix
	 * @return an integer
	 */
	public int numIslands(boolean[][] grid) {
		int cnt = 0;
		if (grid == null || grid.length == 0) {
			return cnt;
		}

		UnionFind uFind = new UnionFind(grid.length * grid[0].length);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					++cnt;
					if (i - 1 >= 0 && grid[i - 1][j] && uFind.compressed_find((i - 1) * grid[0].length + j) != uFind
							.compressed_find(i * grid[0].length + j)) {
						uFind.compressed_merge((i - 1) * grid[0].length + j, i * grid[0].length + j);
						--cnt;
					}
					if (j - 1 >= 0 && grid[i][j - 1] && uFind.compressed_find(i * grid[0].length + j - 1) != uFind
							.compressed_find(i * grid[0].length + j)) {
						uFind.compressed_merge(i * grid[0].length + j - 1, i * grid[0].length + j);
						--cnt;
					}
				}
			}
		}

		return cnt;
	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		ArrayList<Integer> solutions = new ArrayList<>();
		int cnt = 0;
		UnionFind uFind = new UnionFind(m * n);

		boolean[] seas = new boolean[m * n];

		for (int k = 0; k < positions.length; k++) {
			++cnt;

			int[] position = positions[k];
			int index = position[0] * n + position[1];
			seas[index] = true;

			if (position[0] - 1 >= 0 && seas[(position[0] - 1) * n + position[1]]
					&& uFind.compressed_find((position[0] - 1) * n + position[1]) != uFind.compressed_find(index)) {
				uFind.compressed_merge(index, (position[0] - 1) * n + position[1]);
				--cnt;
			}
			if (position[1] - 1 >= 0 && seas[(position[0]) * n + position[1] - 1]
					&& uFind.compressed_find((position[0]) * n + position[1] - 1) != uFind.compressed_find(index)) {
				uFind.compressed_merge(index, (position[0]) * n + position[1] - 1);
				--cnt;
			}
			if (position[0] + 1 < m && seas[(position[0] + 1) * n + position[1]]
					&& uFind.compressed_find((position[0] + 1) * n + position[1]) != uFind.compressed_find(index)) {
				uFind.compressed_merge(index, (position[0] + 1) * n + position[1]);
				--cnt;
			}
			if (position[1] + 1 < n && seas[(position[0]) * n + position[1] + 1]
					&& uFind.compressed_find((position[0]) * n + position[1] + 1) != uFind.compressed_find(index)) {
				uFind.compressed_merge(index, (position[0]) * n + position[1] + 1);
				--cnt;
			}
			
			solutions.add(cnt);
		}

		return solutions;
	}
	
	public static void main(String[] args) {
		int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
		List<Integer> solutions = new NumIslands().numIslands2(3, 3, positions);
		for (Integer cnt : solutions) {
			System.out.println(cnt);
		}
		
	}
}
