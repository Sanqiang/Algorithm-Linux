package Lintcode.Base.Ladders.StringLadder;

public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
    	if(A == null || B == null || A.length() < B.length()){
    		return false;
    	}
    	
    	int[] checker = new int[0XFF];
    	
    	for(int i = 0; i < A.length(); ++i){
    		char ch = A.charAt(i);
    		++checker[ch];
    	}
    	
    	for(int i = 0; i < B.length(); ++i){
    		char ch = B.charAt(i);
    		--checker[ch];
    		if(checker[ch] < 0){
    			return false;
    		}
    	}    	
    	
    	return true;
    }
}
