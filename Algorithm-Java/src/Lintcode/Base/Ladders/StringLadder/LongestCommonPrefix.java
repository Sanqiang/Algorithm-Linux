package Lintcode.Base.Ladders.StringLadder;

public class LongestCommonPrefix {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return "";
    	}
    	
    	int idx = 0;
    	while(idx < strs[0].length()){
	    	char ch = strs[0].charAt(idx);
	    	for(int i = 1; i < strs.length; ++i){
	    		if(idx >= strs[i].length() || strs[i].charAt(idx) != ch){
	    			return strs[0].substring(0, idx);
	    		}
	    	}
	    	++idx;
    	}
    	
    	return strs[0];
    }
}
