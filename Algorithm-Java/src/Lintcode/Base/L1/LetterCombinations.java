package Lintcode.Base.L1;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinations {
	/**
	 * @param digits
	 *            A digital string
	 * @return all posible letter combinations
	 */
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> results = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return results;
		}
		
		HashMap<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		
		dfs(map, results, new StringBuilder(), digits, 0);
		
		return results;
	}

	void dfs(HashMap<Character, String> map, ArrayList<String> results, StringBuilder result, String digits, int pos) {
		if (pos == digits.length()) {
			results.add(result.toString());
			return;
		}
		
		
		char ch = digits.charAt(pos);
		if (map.containsKey(ch)) {
			String chars = map.get(ch);
			for (int i = 0; i < chars.length(); i++) {
				result.append(chars.charAt(i));
				dfs(map, results, result, digits, 1 + pos);
				result.deleteCharAt(result.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> results = new LetterCombinations().letterCombinations("52");
		for (String result : results) {
			System.out.println(result);
		}
	}
}
