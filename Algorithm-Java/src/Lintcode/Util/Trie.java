package Lintcode.Util;

import java.util.HashMap;

public class Trie {
	public boolean marked;
	public HashMap<Character, Trie> children;
	
	public Trie(){
		this.children = new HashMap<Character, Trie>();
	}
	
	
}
