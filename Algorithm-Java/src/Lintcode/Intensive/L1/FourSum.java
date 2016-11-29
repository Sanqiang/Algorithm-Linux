package Lintcode.Intensive.L1;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	/**
	 * @param numbers
	 *            : Give an array numbersbers of n integer
	 * @param target
	 *            : you need to find four elements that's sum of target
	 * @return : Find all unique quadruplets in the array which gives the sum of
	 *         zero.
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		Arrays.sort(numbers);

		for (int i = 0; i < numbers.length; i++) {
			if (i != 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < numbers.length; j++) {
				if (j != i + 1 && numbers[j] == numbers[j - 1]) {
					continue;
				}
				int sub_target = target - numbers[i] - numbers[j];

				int left = j + 1, right = numbers.length - 1;
				while (left < right) {
					if (numbers[left] + numbers[right] > sub_target) {
						--right;
					} else if (numbers[left] + numbers[right] < sub_target) {
						++left;
					} else {
						ArrayList<Integer> result = new ArrayList<>();
						result.add(numbers[i]);
						result.add(numbers[j]);
						result.add(numbers[left]);
						result.add(numbers[right]);
						results.add(result);
						left++;
						right--;
						while (left < right && numbers[left] == numbers[left - 1]) {
							left++;
						}
						while (left < right && numbers[right] == numbers[right + 1]) {
							right--;
						}
					}
				}

			}
		}

		return results;
	}
}
