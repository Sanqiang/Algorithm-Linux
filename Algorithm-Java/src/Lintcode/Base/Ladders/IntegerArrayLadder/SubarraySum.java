package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		HashMap<Integer, ArrayList<Integer>> checker = new HashMap<>();
		int cnt = 0;
		for(int i = 0; i < nums.length; ++i){
			cnt += nums[i];
			if(!checker.containsKey(cnt)){
				checker.put(cnt, new ArrayList<Integer>());
			}
			checker.get(cnt).add(i);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		if(checker.containsKey(0)){
			result.add(0);
			result.add(checker.get(0).get(0));
			return result;
		}
		
		for(int cnt_temp : checker.keySet()){
			ArrayList<Integer> idx_list = checker.get(cnt_temp);
			if(idx_list.size() >= 2){
				for(int i = idx_list.size() - 1; i >= 1; --i){
					result.add(idx_list.get(i - 1) + 1);
					result.add(idx_list.get(i));
					return result;
				}
			}
		}
		
		return result;
	}
}
