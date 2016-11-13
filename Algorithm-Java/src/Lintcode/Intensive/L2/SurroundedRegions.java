package Lintcode.Intensive.L2;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	/**
	 * @param board
	 *            a 2D board containing 'X' and 'O'
	 * @return void
	 */
	public void surroundedRegions(char[][] board) {
		if(board == null || board.length ==0 || board[0].length == 0){
			return;
		}
		int m = board.length, n = board[0].length;
		boolean[] checked = new boolean[m * n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == m - 1 || j == n-1) {
					if (board[i][j] == 'O') {
						board[i][j] = 'M';
						// bfs
						Queue<Integer> queue = new LinkedList<>();
						queue.add(i * n + j);
						while (!queue.isEmpty()) {
							int pos = queue.poll();
							int x = pos / n, y = pos % n;
							if (x - 1 >= 0 && !checked[(x - 1) * n + y] && board[x - 1][y] == 'O') {
								board[x - 1][y] = 'M';
								checked[(x - 1) * n + y] = true;
								queue.add((x - 1) * n + y);
							}
							if (y - 1 >= 0 && !checked[(x) * n + y - 1] && board[x][y - 1] == 'O') {
								board[x][y - 1] = 'M';
								checked[(x) * n + y - 1] = true;
								queue.add((x) * n + y - 1);
							}
							if (x + 1 < m && !checked[(x + 1) * n + y] && board[x + 1][y] == 'O') {
								board[x + 1][y] = 'M';
								checked[(x + 1) * n + y] = true;
								queue.add((x + 1) * n + y);
							}
							if (y + 1 < n && !checked[(x) * n + y + 1] && board[x][y + 1] == 'O') {
								board[x][y + 1] = 'M';
								checked[(x) * n + y + 1] = true;
								queue.add((x) * n + y + 1);
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 'M'){
					board[i][j] = 'O';
				}
			}
		}
	}
}
