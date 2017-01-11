package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LadderLength {
	/**
	 * @param start,
	 *            a string
	 * @param end,
	 *            a string
	 * @param dict,
	 *            a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict == null) {
			return 0;
		}

		if (start.equals(end)) {
			return 1;
		}

		dict.add(start);
		dict.add(end);

		Queue<String> q = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		q.offer(start);
		set.add(start);

		int length = 1;
		while (!q.isEmpty()) {
			++length;
			int qsize = q.size();
			for (int i = 0; i < qsize; ++i) {
				String temp = q.poll();
				ArrayList<String> next_words = getNextWords(temp, dict,set);
				for (String next_word : next_words) {
					if (next_word.equals(end)) {
						return length;
					}

					q.offer(next_word);
					set.add(next_word);
				}
			}
		}

		return -1;
	}

	ArrayList<String> getNextWords2(String start, Set<String> dict, HashSet<String> set) {
		ArrayList<String> words = new ArrayList<>();
		// edit distance
		for (String word : dict) {
			if (!set.contains(word) && editDist(start, word) == 1) {
				words.add(word);
			}
		}
		return words;
	}

	int editDist(String word1, String word2) {
		int[][] tab = new int[1 + word1.length()][1 + word2.length()];

		tab[0][0] = 0;

		for (int i = 1; i <= word1.length(); ++i) {
			tab[i][0] = tab[i - 1][0] + 1;

		}
		for (int i = 1; i <= word2.length(); ++i) {
			tab[0][i] = tab[0][i - 1] + 1;
		}

		for (int i = 1; i <= word1.length(); ++i) {
			for (int j = 1; j <= word2.length(); ++j) {
				int base = tab[i - 1][j - 1];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					tab[i][j] = base;
				} else {
					tab[i][j] = base + 1;
				}
			}
		}
		return tab[word1.length()][word2.length()];
	}

	// replace character of a string at given index to a given character
	// return a new string
	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}

	// get connections with given word.
	// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	// it will return ['hit', 'hog']
	private ArrayList<String> getNextWords(String word, Set<String> dict, HashSet<String> set) {
		ArrayList<String> nextWords = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (!set.contains(nextWord) && dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;
	}
}
