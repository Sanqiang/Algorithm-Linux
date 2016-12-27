package Lintcode.Base.Ladders.StringLadder;

public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
    	if(source == null || target == null || source.length() < target.length()){
    		return -1;
    	}
    	if(target.length() == 0){
    		return 0;
    	}
    	
    	int i = 0, j = 0;
    	for(;i < source.length(); ++i){
    		int temp_i = i;
    		while(temp_i < source.length() && source.charAt(temp_i) == target.charAt(j)){
    			++temp_i;
    			++j;
    			if(target.length() == j){
    				return i;
    			}
    		}
    		j = 0;
    	}
    	
    	return -1;
    }
}
