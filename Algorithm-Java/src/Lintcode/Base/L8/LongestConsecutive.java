package Lintcode.Base.L8;

import java.util.HashSet;

public class LongestConsecutive {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return an integer
	 */
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int longest = 0;
		for (int i = 0; i < nums.length; i++) {
			int down = nums[i] - 1;
			while (set.contains(down)) {
				set.remove(down);
				down--;
			}

			int up = nums[i] + 1;
			while (set.contains(up)) {
				set.remove(up);
				up++;
			}

			longest = Math.max(longest, up - down - 1);
		}

		return longest;
	}
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		new LongestConsecutive().longestConsecutive(nums);
	}
}
