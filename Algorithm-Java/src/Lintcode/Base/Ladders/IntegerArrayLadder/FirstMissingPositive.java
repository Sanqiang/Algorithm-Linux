package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.HashSet;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
    
        int start = 1;
        HashSet<Integer> checker = new HashSet<>();
        for(int i = 0; i < A.length; ++i){
        	if(A[i] > 0 && A[i] < start){
        		start = A[i];
        	}
        	checker.add(A[i]);
        }
    
        while(true){
        	if(checker.contains(start)){
        		++start;
        	}else{
        		break;
        	}
        }
        
        return start;
    }
}
