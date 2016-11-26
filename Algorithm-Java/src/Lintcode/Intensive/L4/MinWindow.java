package Lintcode.Intensive.L4;

import java.util.HashMap;
import java.util.HashSet;

public class MinWindow {
	/**
	 * @param source:
	 *            A string
	 * @param target:
	 *            A string
	 * @return: A string denote the minimum window Return "" if there is no such
	 *          a string
	 */
	public String minWindow(String source, String target) {
		if (source == null || source.length() == 0 || target == null || target.length() == 0) {
			return "";
		}
		int[] checker = new int[0XFF], origin = new int[0XFF];
		HashSet<Character> chars = new HashSet<>();
		HashSet<Character> chars_issue = new HashSet<>();
		for (int i = 0; i < target.length(); i++) {
			char ch = target.charAt(i);
			checker[ch]++;
			chars.add(ch);
			chars_issue.add(ch);
		}

		int left = 0, right = 0, max_left = 0, max_right = Integer.MAX_VALUE;
		for (left = 0; left < source.length(); left++) {
			while (right < source.length() && chars_issue.size() > 0) {
				char ch_right = source.charAt(right);
				if (chars.contains(ch_right)) {
					checker[ch_right]--;
				}
				if (checker[ch_right] == 0) {
					chars_issue.remove(ch_right);
				}
				if (chars_issue.isEmpty() && right - left < max_right - max_left) {
					max_left = left;
					max_right = right;
				}
				++right;
			}
			if (chars_issue.isEmpty() && right - 1 - left < max_right - max_left) {
				max_left = left;
				max_right = right - 1;
			}
			char ch_left = source.charAt(left);
			if (chars.contains(ch_left)) {
				checker[ch_left]++;
				if (checker[ch_left] > 0) {
					chars_issue.add(ch_left);
				}
			}
		}
		if (max_right == Integer.MAX_VALUE) {
			return "";
		}
		
		return source.substring(max_left, max_right + 1);
	}

	public static void main(String[] args) {
		String win = new MinWindow().minWindow("adfqeradboaf23098724huhfda923hadf78adfhadfhadfaodiyfas8", "dfje89affefy8f");
		System.out.println(win);
	}
}
