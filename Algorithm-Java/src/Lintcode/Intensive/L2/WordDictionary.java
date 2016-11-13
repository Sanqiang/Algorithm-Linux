package Lintcode.Intensive.L2;

import java.util.ArrayList;

import Lintcode.Util.Trie;

public class WordDictionary {
	
	Trie root ; 
	
	public WordDictionary() {
		this.root = new Trie();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
    	Trie temp = root;
    	for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!temp.children.containsKey(ch)) {
				temp.children.put(ch, new Trie());
			}
			temp = temp.children.get(ch);
		}
    	temp.marked = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	ArrayList<Trie> temp = new ArrayList<Trie>();
    	temp.add(root);
    	for (int i = 0; i < word.length(); i++) {
    		char ch = word.charAt(i);
    		
    		ArrayList<Trie> next_temp = new ArrayList<Trie>();
    		if (ch == '.') {
    			for (Trie trie : temp) {
					for (char next_ch : trie.children.keySet()) {
						next_temp.add(trie.children.get(next_ch));
					}
				}
			}else{
				for (Trie trie : temp) {
					if (trie.children.containsKey(ch)) {
						next_temp.add(trie.children.get(ch));
					}
				}
			}
    		temp = next_temp;
    		if (temp.isEmpty()) {
				return false;
			}
		}
    	for (Trie trie : temp) {
			if (trie.marked) {
				return true;
			}
		}
    	return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");