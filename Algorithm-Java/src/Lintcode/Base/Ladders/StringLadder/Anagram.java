package Lintcode.Base.Ladders.StringLadder;

public class Anagram {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
    	if(s == null || t == null || s.length() != t.length()){
    		return false;
    	}

    	int[] checker = new int[0XFF];
    	for(int i = 0; i < s.length(); ++i){
    		char ch = s.charAt(i);
    		++checker[ch];
    	}
    	for(int i = 0; i < s.length(); ++i){
    		char ch = t.charAt(i);
    		--checker[ch];
    		if(checker[ch] < 0){
    			return false;
    		}
    	}
    	
        return true;
    }
}
