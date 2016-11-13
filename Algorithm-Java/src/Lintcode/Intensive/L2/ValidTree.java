package Lintcode.Intensive.L2;

import Lintcode.Util.UnionFind;

public class ValidTree {
	/**
	 * @param n
	 *            an integer
	 * @param edges
	 *            a list of undirected edges
	 * @return true if it's a valid tree, or false
	 */
	public boolean validTree(int n, int[][] edges) {
		if (edges == null || edges.length == 0) {
			if (n == 1) {
				return true;
			} else {
				return false;
			}
		}
		UnionFind uFind = new UnionFind(n);
		for (int i = 0; i < edges.length; i++) {
			int[] pos = edges[i];
			int s = pos[0], e = pos[1];

			if (uFind.compressed_find(s) == uFind.compressed_find(e)) {
				return false;
			}
			uFind.compressed_merge(s, e);

		}
		int mark = uFind.compressed_find(0);
		for (int i = 1; i < n; i++) {
			if (uFind.compressed_find(i) != mark) {
				return false;
			}
		}
		return true;
	}
}
