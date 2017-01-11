package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindLadders {
	/**
	 * @param start,
	 *            a string
	 * @param end,
	 *            a string
	 * @param dict,
	 *            a set of string
	 * @return a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> results = new ArrayList<>();
		if (dict == null) {
			return results;
		}

		if (start.equals(end)) {
			List<String> result = new ArrayList<>();
			result.add(start);
			result.add(end);
			results.add(result);
			return results;
		}

		dict.add(start);
		dict.add(end);

		HashSet<String> set = new HashSet<>();
		set.add(start);

		List<String> result = new ArrayList<>();
		result.add(start);
		dfs(start, dict, set, result, results, end);
		
		int min_len = Integer.MAX_VALUE;
		for(List<String> temp : results){
			min_len = Math.min(temp.size(), min_len);
		}
		List<List<String>> nresults = new ArrayList<>();
		for(List<String> temp : results){
			if(temp.size() == min_len){
				nresults.add(temp);
			}
		}

		return nresults;
	}

	void dfs(String word, Set<String> dict, HashSet<String> set, List<String> result, List<List<String>> results, String end) {
		if(word.equals(end)){
			results.add(new ArrayList<>(result));
			return;
		}
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (!set.contains(nextWord) && dict.contains(nextWord)) {
					result.add(nextWord);
					set.add(nextWord);
					dfs(nextWord, dict, set, result, results, end);
					set.remove(nextWord);
					result.remove(result.size() - 1);
				}
			}
		}
	}

	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}
}
