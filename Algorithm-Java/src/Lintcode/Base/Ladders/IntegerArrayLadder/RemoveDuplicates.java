package Lintcode.Base.Ladders.IntegerArrayLadder;

public class RemoveDuplicates {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
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
