package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		Arrays.sort(numbers);

		ArrayList<ArrayList<Integer>> results = new ArrayList<>();

		for (int i = 0; i < numbers.length; ++i) {
			if (i != 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < numbers.length; ++j) {
				if (j != i + 1 && numbers[j] == numbers[j - 1]) {
					continue;
				}
				int temp_target = target - numbers[i] - numbers[j];
				HashMap<Integer, Integer> checker = new HashMap<>();
				HashSet<String> duplicate_checker = new HashSet<>();
				for (int k = j + 1; k < numbers.length; ++k) {
					String duplicate_key = String.valueOf(numbers[k]) + "_" + String.valueOf(temp_target - numbers[k]);
					if (checker.containsKey(temp_target - numbers[k]) && !duplicate_checker.contains(duplicate_key)) {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(numbers[i]);
						result.add(numbers[j]);
						result.add(temp_target - numbers[k]);
						result.add(numbers[k]);
						results.add(result);
						duplicate_checker.add(duplicate_key);
					}
					checker.put(numbers[k], k);
				}
			}
		}

		return results;
	}
}
