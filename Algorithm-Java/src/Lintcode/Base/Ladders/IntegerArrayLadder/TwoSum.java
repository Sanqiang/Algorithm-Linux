package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < numbers.length; ++i){
			if(map.containsKey(target - numbers[i])){
				int[] result = new int[2];
				result[0] = 1 + map.get(target - numbers[i]);
				result[1] = 1 + i;
				return result;
			}
			map.put(numbers[i], i);
		}
		return null;
    }
}
