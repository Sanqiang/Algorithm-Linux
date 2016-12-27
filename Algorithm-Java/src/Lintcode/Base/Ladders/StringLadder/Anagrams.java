package Lintcode.Base.Ladders.StringLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */

	int getHash(String str) {
		int h = str.length();
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); ++i) {
			++cnt[str.charAt(i) - 'a'];
		}
		for (int i = 0; i < 26; ++i) {
			h = h * 26 + cnt[i];
		}
		return h;
	}

	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<>();
		if (strs == null) {
			return result;
		} 
		
		HashMap<Integer, ArrayList<String>> helper = new HashMap<>();
		for(String str : strs){
			int h = getHash(str);
			if(!helper.containsKey(h)){
				helper.put(h, new ArrayList<String>());
			}
			helper.get(h).add(str);
		}
		
		for(ArrayList<String> temp_list : helper.values()){
			if(temp_list.size() > 1){
				result.addAll(temp_list);
			}
		}
		
		return result;
	}
}
