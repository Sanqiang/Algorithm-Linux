package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	/**
	 * @param s:
	 *            A string
	 * @return: A list of lists of string
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return results;
		}
		dfs(results, new ArrayList<String>(), 0, s);
		return results;
	}

	void dfs(List<List<String>> results, ArrayList<String> result, int pos, String s) {
		if (pos == s.length()) {
			results.add(new ArrayList<>(result));
			return;
		}
		
		for (int i = pos; i < s.length(); i++) {
			String str = s.substring(pos, 1 + i);
			if (isValidPalindrome(str)) {
				result.add(str);
				dfs(results, result, i + 1, s);
				result.remove(result.size() - 1);
			}
		}
	}

	boolean isValidPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			} else {
				++left;
				--right;
			}
		}
		return true;
	}
}
