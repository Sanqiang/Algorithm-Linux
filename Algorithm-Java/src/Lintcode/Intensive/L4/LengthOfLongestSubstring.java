package Lintcode.Intensive.L4;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	/**
	 * @param s:
	 *            a string
	 * @return: an integer
	 */
	public int lengthOfLongestSubstring(String s) {
		int longest_length = 0;
		if (s == null || s.length() == 0) {
			return longest_length;
		}

		boolean[] checker = new boolean[0XFF];
		int left = 0, right = 0;
		for (left = 0; left < s.length(); left++) {
			while (right < s.length() &&  !checker[s.charAt(right)]) {
				char ch_right = s.charAt(right);
				++right;
				checker[ch_right] = true;
				if (right - left > longest_length) {
					longest_length = right - left;
				}
			}
			checker[s.charAt(left)] = false;
		}

		return longest_length;
	}
}
