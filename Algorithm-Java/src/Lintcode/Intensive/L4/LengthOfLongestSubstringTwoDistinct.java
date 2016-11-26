package Lintcode.Intensive.L4;

import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> checker = new HashMap<>();
		int left = 0, right = 0, longest_substr = 0, distinct_char = 0;
		for (left = 0; left < s.length(); left++) {
			while (right < s.length() && distinct_char <= 2) {
				char ch_right = s.charAt(right);
				if (!checker.containsKey(ch_right)) {
					checker.put(ch_right, 0);
					distinct_char++;
				}
				checker.put(ch_right, 1 + checker.get(ch_right));

				++right;
				if (distinct_char == 2 && right - left > longest_substr) {
					longest_substr = right - left;
				}
			}

			char ch_left = s.charAt(left);
			checker.put(ch_left, checker.get(ch_left) - 1);
			if (checker.get(ch_left) == 0) {
				distinct_char--;
			}
		}
		return longest_substr;
	}

	public static void main(String[] args) {
		int longest = new LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("abac");
		System.out.println(longest);
	}
}
