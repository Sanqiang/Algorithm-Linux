package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;

public class TotalNQueens {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
		int[] tab = new int[n];
		for (int i = 0; i < n; ++i) {
			tab[i] = -1;
		}
		ArrayList<ArrayList<String>> results = new ArrayList<>();
		dfs(tab, 0, results);
		return results.size();
	}

	void dfs(int[] tab, int row_idx, ArrayList<ArrayList<String>> results) {
		if (row_idx == tab.length) {
			results.add(getResult(tab));
		}

		for (int col_idx = 0; col_idx < tab.length; ++col_idx) {
			if (isValidate(tab, row_idx, col_idx)) {
				tab[row_idx] = col_idx;
				dfs(tab, row_idx + 1, results);
				tab[row_idx] = -1;
			}
		}
	}

	boolean isValidate(int[] tab, int row_idx, int col_idx) {
		for (int i = row_idx - 1; i >= 0; --i) {
			if (tab[i] == col_idx) {
				return false;
			} else if (tab[i] == col_idx - 1 - (row_idx - 1 - i)) {
				return false;
			} else if (tab[i] == col_idx + 1 + (row_idx - 1 - i)) {
				return false;
			}
		}
		for (int i = col_idx - 1; i >= 0; --i) {
			if (tab[row_idx] == i) {
				return false;
			}
		}
		return true;
	}

	ArrayList<String> getResult(int[] tab) {
		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < tab.length; ++i) {
			StringBuilder sb = new StringBuilder();
			int j = 0;
			for (; j < tab[i]; ++j) {
				sb.append(".");
			}
			sb.append("Q");
			++j;
			for (; j < tab.length; ++j) {
				sb.append(".");
			}
			result.add(sb.toString());
		}
		return result;
	}
}
