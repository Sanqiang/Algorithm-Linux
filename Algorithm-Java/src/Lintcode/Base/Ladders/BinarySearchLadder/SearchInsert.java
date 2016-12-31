package Lintcode.Base.Ladders.BinarySearchLadder;

public class SearchInsert {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
    	if (A == null || A.length == 0){
    		return 0;
    	}
    	
    	int start = 0, end = A.length - 1;
    	while(start + 1 < end){
    		int mid = start + (end - start) / 2;
    		if(A[mid] <= target){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	
    	if (target <= A[start]){
    		return start;
    	}else if (target >= A[start] && target <= A[end]){
    		return 1 + start;
    	}else{
    		return 1 + end;
    	}
    }
}
