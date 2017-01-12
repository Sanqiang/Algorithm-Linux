package Lintcode.Base.Ladders.DataStructureLadder;

import java.util.ArrayList;
import java.util.HashMap;

public class WordSearchII {
	/**
	 * @param board:
	 *            A list of lists of character
	 * @param words:
	 *            A list of string
	 * @return: A list of string
	 */
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<>();

		Trie trie = new Trie();
		for (String word : words) {
			trie.addWord(word);
		}

		boolean[][] checker = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				StringBuilder sb = new StringBuilder();
				dfs(trie.root, result, i, j, board, checker, sb);
			}
		}

		return result;
	}

	void dfs(TrieNode node, ArrayList<String> result, int i, int j, char[][] board, boolean[][] checker,
			StringBuilder sb) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}

		if (!checker[i][j] && node.children.containsKey(board[i][j])) {
			checker[i][j] = true;
			sb.append(board[i][j]);

			TrieNode nnode = node.children.get(board[i][j]);

			if (nnode.isWord && !result.contains(sb.toString())) {
				result.add(sb.toString());
			}

			dfs(nnode, result, i + 1, j, board, checker, sb);
			dfs(nnode, result, i - 1, j, board, checker, sb);
			dfs(nnode, result, i, j + 1, board, checker, sb);
			dfs(nnode, result, i, j - 1, board, checker, sb);

			checker[i][j] = false;
			sb.setLength(sb.length() - 1);
		}
	}

	class TrieNode {
		char ch;
		boolean isWord = false;
		HashMap<Character, TrieNode> children;

		public TrieNode(char ch) {
			this.ch = ch;
			this.children = new HashMap<>();
		}
	}

	class Trie {
		public TrieNode root;

		public Trie() {
			this.root = new TrieNode('$');
		}

		public void addWord(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); ++i) {
				char ch = word.charAt(i);
				if (node.children.containsKey(ch)) {
					node = node.children.get(ch);
				} else {
					TrieNode nnode = new TrieNode(ch);
					node.children.put(ch, nnode);
					node = nnode;
				}
			}
			node.isWord = true;
		}

		public boolean checkWord(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); ++i) {
				char ch = word.charAt(i);
				if (node.children.containsKey(ch)) {
					node = node.children.get(ch);
				} else {
					return false;
				}
			}
			return node.isWord;
		}
	}
}
