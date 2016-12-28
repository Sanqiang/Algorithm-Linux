package Lintcode.Base.Ladders.StringLadder;

public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	if(A == null || B == null || A.length() == 0 || B.length() == 0){
    		return 0;
    	}
    	int max_value = 0;
    	int[][] tab = new int[1 + A.length()][1 + B.length()];   	
    	
    	//process tab
    	for(int i = 1; i <= A.length(); ++i){
    		for(int j = 1; j <= B.length(); ++j){
    			int val = 0;
    			if(A.charAt(i - 1) == B.charAt(j - 1)){
    				val = 1 + tab[i - 1][j - 1];
    			}
    			tab[i][j] = val;
    			max_value = Math.max(max_value, val);
    		}
    	}
    	
    	return max_value;
    }
}
