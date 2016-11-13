package Lintcode.Intensive.L2;

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
    	Trie temp = root;
    	for (int i = 0; i < word.length(); i++) {
			
		}
    	return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");