package Lintcode.Base.Ladders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringL {
	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public boolean anagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		int[] checks = new int[0XFF];
		for (int i = 0; i < s.length(); ++i) {
			checks[s.charAt(i)]++;
		}

		for (int i = 0; i < t.length(); ++i) {
			checks[t.charAt(i)]--;
			if (checks[t.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */
	public boolean compareStrings(String A, String B) {
		if (A == null || B == null || B.length() > A.length()) {
			return false;
		}

		int[] checks = new int[0XFF];
		for (int i = 0; i < A.length(); i++) {
			checks[A.charAt(i)]++;
		}

		for (int i = 0; i < B.length(); i++) {
			checks[B.charAt(i)]--;
			if (checks[B.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		if (source.length() == 0 && target.length() == 0) {
			return 0;
		}

		int t_i = 0;
		for (int s_i = 0; s_i < source.length() - target.length(); ++s_i) {

			for (t_i = 0; t_i < target.length(); ++t_i) {
				if (source.charAt(s_i + t_i) != target.charAt(t_i)) {
					break;
				}
			}
			if (t_i == target.length()) {
				return s_i;
			}

		}

		return -1;
	}

	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */
	long getHash(int[] check) {
		long hash = 0;
		for (int cnt : check) {
			hash += cnt;
			hash *= 26;
		}
		return hash;
	}

	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();

		HashMap<Long, ArrayList<String>> mapper = new HashMap<>();
		if (strs == null) {
			return result;
		}

		for (int i = 0; i < strs.length; ++i) {
			String str = strs[i];

			int[] check = new int[26];
			for (int j = 0; j < str.length(); ++j) {
				check[str.charAt(j) - 'a']++;
			}

			long hash = getHash(check);
			if (!mapper.containsKey(hash)) {
				mapper.put(hash, new ArrayList<String>());
			}
			mapper.get(hash).add(str);
		}

		for (ArrayList<String> anagrams : mapper.values()) {
			if (anagrams.size() > 1) {
				result.addAll(anagrams);
			}
		}

		return result;
	}

	/**
	 * @param A,
	 *            B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public int longestCommonSubstring2(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}

		int len_a = A.length(), len_b = B.length();
		int[][] tab = new int[len_a][len_b];

		if (A.charAt(0) == B.charAt(0)) {
			tab[0][0] = 1;
		}

		for (int i = 1; i < len_a; ++i) {
			if (A.charAt(i) == B.charAt(0)) {
				tab[i][0] = 1;
			}
		}

		for (int i = 1; i < len_b; ++i) {
			if (A.charAt(0) == B.charAt(i)) {
				tab[0][i] = 1;
			}
		}

		for (int i = 1; i < len_a; ++i) {
			for (int j = 1; j < len_b; ++j) {
				if (A.charAt(i) == B.charAt(j)) {
					tab[i][j] = tab[i - 1][j - 1] + 1;
				} else {
					tab[i][j] = 0;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < len_a; ++i) {
			for (int j = 0; j < len_b; ++j) {
				max = Math.max(max, tab[i][j]);
			}
		}
		return max;
	}

	/**
	 * @param strs:
	 *            A list of strings
	 * @return: The longest common prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int prefix_idx = 0;
		boolean is_finished = false;
		while (!is_finished) {
			char ch = '?';
			for (String str : strs) {
				if (ch == '?') {
					if (prefix_idx >= str.length()) {
						is_finished = true;
						break;
					}
					ch = str.charAt(prefix_idx);
				}
				if (prefix_idx >= str.length() || str.charAt(prefix_idx) != ch) {
					is_finished = true;
					break;
				}
			}
			prefix_idx++;
		}

		return strs[0].substring(0, prefix_idx);
	}

	
	
	
	public static void main(String[] args) {
		String[] strs = { "ABCD", "ABEF", "ACEF" };
		new StringL().longestCommonPrefix(strs);
	}
}
