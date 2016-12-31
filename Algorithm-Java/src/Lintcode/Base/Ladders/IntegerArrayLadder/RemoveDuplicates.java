package Lintcode.Base.Ladders.IntegerArrayLadder;

public class RemoveDuplicates {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int loop_idx = 0, true_idx = 0;
        while(loop_idx < A.length){
        	if(loop_idx != true_idx){
        		A[true_idx] = A[loop_idx];
        	}
        	int val = A[loop_idx];
        	++true_idx;
        	++loop_idx;
        	while(loop_idx < A.length && A[loop_idx] == val){
        		++loop_idx;
        	}
        }
    
        return true_idx;
    }
    
    
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates2(int[] nums) {
        if(nums == null){
        	return 0;
        }
        
        int loop_idx = 0, true_idx = 0;
        while(loop_idx < nums.length){
        	int val = nums[loop_idx];
        	if(loop_idx < nums.length && val == nums[loop_idx]){
        		if(loop_idx < nums.length && loop_idx != true_idx){
        			nums[true_idx] = nums[loop_idx];
        		}
        		loop_idx++;
        		true_idx++;
        	}
        	if(loop_idx < nums.length && val == nums[loop_idx]){
        		if(loop_idx < nums.length && loop_idx != true_idx){
        			nums[true_idx] = nums[loop_idx];
        		}
        		loop_idx++;
        		true_idx++;
        	}
        	
        	while(loop_idx < nums.length && val == nums[loop_idx]){
        		loop_idx++;
        	}
        }
        
        return true_idx;
    }
}
