package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();

		Arrays.sort(numbers);
		for (int k = 0; k < numbers.length; ++k) {
			if(k != 0 && numbers[k] == numbers[k - 1]){
				continue;
			}
			int target = -numbers[k], i = k + 1, j = numbers.length - 1;
			while (i < j) {
				if(i != k + 1 && numbers[i] == numbers[i - 1]){
					++i;
					continue;
				}
				
				if (numbers[i] + numbers[j] == target) {
					ArrayList<Integer> result = new ArrayList<>();
					result.add(numbers[k]);
					result.add(numbers[i]);
					result.add(numbers[j]);
					results.add(result);
					++i;
					--j;
				} else if (numbers[i] + numbers[j] < target) {
					++i;
				} else {
					--j;
				}
			}
		}

		return results;
	}
}
