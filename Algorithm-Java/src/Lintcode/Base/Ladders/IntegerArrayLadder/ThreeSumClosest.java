package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.Arrays;

public class ThreeSumClosest {
	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	public int threeSumClosest(int[] numbers, int target) {
		int closest = Integer.MAX_VALUE;
		int sum = Integer.MAX_VALUE - target;

		Arrays.sort(numbers);
		for (int k = 0; k < numbers.length - 2; ++k) {
			int i = k + 1, j = numbers.length - 1;
			while (i < j) {
				int diff = Math.abs(target - numbers[k] - numbers[i] - numbers[j]);
				if (diff < closest) {
					closest = diff;
					sum = numbers[i] + numbers[j] + numbers[k];
				}
				if (numbers[i] + numbers[j] + numbers[k] <= target) {
					++i;
				} else {
					--j;
				}
			}
		}

		return sum;
	}
}
